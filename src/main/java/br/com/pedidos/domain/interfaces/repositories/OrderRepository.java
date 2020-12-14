package br.com.pedidos.domain.interfaces.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pedidos.domain.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select orders.* from orders inner join clients on orders.client_id = clients.id where clients.cpf = :cpf", nativeQuery = true)
    public List<Order> findByClientCpf(@Param("cpf") String cpf);    
}
