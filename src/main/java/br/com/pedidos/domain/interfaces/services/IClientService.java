package br.com.pedidos.domain.interfaces.services;

import br.com.pedidos.domain.models.Client;

public interface IClientService {
    void create(Client client) throws Exception;
    void update(Client client);
    void delete(Long id) throws Exception;
}
