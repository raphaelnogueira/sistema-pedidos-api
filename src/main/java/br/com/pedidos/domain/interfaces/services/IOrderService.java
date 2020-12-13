package br.com.pedidos.domain.interfaces.services;

import br.com.pedidos.domain.models.Order;

public interface IOrderService {
    void create(Order order);
}
