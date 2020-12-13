package br.com.pedidos.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.domain.interfaces.repositories.OrderRepository;
import br.com.pedidos.domain.interfaces.services.IOrderService;
import br.com.pedidos.domain.models.Order;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void create(Order order) {
        orderRepository.saveAndFlush(order);
    }
    
}
