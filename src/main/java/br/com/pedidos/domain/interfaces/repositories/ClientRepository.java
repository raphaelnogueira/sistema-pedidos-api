package br.com.pedidos.domain.interfaces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedidos.domain.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
