package br.com.pedidos.domain.interfaces.services;

import br.com.pedidos.domain.models.Client;

public interface IClientService {
    void create(Client client);
    void update(Client client);
    void delete(Long id) throws Exception;
}
