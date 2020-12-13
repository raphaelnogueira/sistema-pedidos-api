package br.com.pedidos.application.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.application.interfaces.IMapper;
import br.com.pedidos.application.interfaces.IOrderAppService;
import br.com.pedidos.application.viewmodels.OrderViewModel;
import br.com.pedidos.domain.interfaces.repositories.OrderRepository;
import br.com.pedidos.domain.interfaces.services.IOrderService;
import br.com.pedidos.domain.models.Order;

@Service
public class OrderAppService implements IOrderAppService {

    private OrderRepository orderRepository;
    private IOrderService orderService;
    private IMapper mapper;

    @Autowired
    public OrderAppService(OrderRepository orderRepository, IOrderService orderService, IMapper mapper) {
        this.orderRepository = orderRepository;
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
        return null;
    }

    @Override
    public void create(OrderViewModel orderViewModel) {
        Order order = mapper.map(orderViewModel, Order.class);
        orderService.create(order);
    }    
}
