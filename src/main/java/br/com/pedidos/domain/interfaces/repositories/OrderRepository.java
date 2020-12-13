package br.com.pedidos.domain.interfaces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedidos.domain.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
