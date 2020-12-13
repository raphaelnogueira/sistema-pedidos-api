package br.com.pedidos.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.domain.interfaces.repositories.ClientRepository;
import br.com.pedidos.domain.interfaces.services.IClientService;
import br.com.pedidos.domain.models.Client;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void create(Client client) {
        clientRepository.saveAndFlush(client);
    }

    @Override
    public void update(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void delete(Long id) throws Exception {
        Client client = clientRepository.findById(id).orElse(null);
        if(client.getOrders().isEmpty()) {
            clientRepository.delete(client);
            return;
        }

        throw new Exception("O cliente não pode ser excluído");
    }
    
}
