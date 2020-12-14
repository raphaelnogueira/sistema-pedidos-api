package br.com.pedidos.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.application.interfaces.IMapper;
import br.com.pedidos.application.interfaces.IOrderAppService;
import br.com.pedidos.application.viewmodels.OrderViewModel;
import br.com.pedidos.domain.interfaces.repositories.ClientRepository;
import br.com.pedidos.domain.interfaces.repositories.OrderItemRepository;
import br.com.pedidos.domain.interfaces.repositories.OrderRepository;
import br.com.pedidos.domain.interfaces.repositories.ProductRepository;
import br.com.pedidos.domain.interfaces.services.IOrderService;
import br.com.pedidos.domain.models.Client;
import br.com.pedidos.domain.models.Order;
import br.com.pedidos.domain.models.OrderItem;
import br.com.pedidos.domain.models.Product;

@Service
public class OrderAppService implements IOrderAppService {

    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private ProductRepository productRepository;
    private OrderItemRepository orderItemRepository;
    private IOrderService orderService;
    private IMapper mapper;

    @Autowired
    public OrderAppService(OrderRepository orderRepository, ClientRepository clientRepository,
        ProductRepository productRepository, OrderItemRepository orderItemRepository, 
        IOrderService orderService, IMapper mapper) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @Override
    public OrderViewModel getById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        return mapper.map(order, OrderViewModel.class);
    }

    @Override
    public List<OrderViewModel> getAll() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
            .map(order -> mapper.map(order, OrderViewModel.class))
            .collect(Collectors.toList());
    }

    @Override
    public List<OrderViewModel> getByClientCpf(String cpf) {
        List<Order> orders = orderRepository.findByClientCpf(cpf);
        
        return orders.stream()
            .map(order -> mapper.map(order, OrderViewModel.class))
            .collect(Collectors.toList());
    }

    @Override
    public void create(OrderViewModel orderViewModel) {
        Order order = mapper.map(orderViewModel, Order.class);

        Client client = clientRepository.findById(order.getClient().getId()).orElse(null);
        order.setClient(client);
        List<OrderItem> itens = order.getItens();
        order.setItens(new ArrayList<>());
        orderService.create(order);

        List<OrderItem> orderItens = new ArrayList<>();
        itens.forEach(item -> {
            Product product = productRepository.findById(item.getProduct().getId()).orElse(null);
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(item.getQuantity());
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItens.add(orderItem);
        });

        orderItemRepository.saveAll(orderItens);
    }    
}
