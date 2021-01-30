package br.com.pedidos.domain.interfaces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pedidos.domain.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  @Query(value = "select clients.* from clients where clients.cpf = :cpf", nativeQuery = true)
  public Client findByCpf(@Param("cpf") String cpf);
}
