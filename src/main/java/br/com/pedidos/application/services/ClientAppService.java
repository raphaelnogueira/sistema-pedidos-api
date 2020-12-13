package br.com.pedidos.application.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.application.interfaces.IClientAppService;
import br.com.pedidos.application.interfaces.IMapper;
import br.com.pedidos.application.viewmodels.ClientViewModel;
import br.com.pedidos.domain.interfaces.repositories.ClientRepository;
import br.com.pedidos.domain.interfaces.services.IClientService;
import br.com.pedidos.domain.models.Client;

@Service
public class ClientAppService implements IClientAppService {

    private IClientService clientService;
    private ClientRepository clientRepository;
    private IMapper mapper;

    @Autowired
    public ClientAppService(IClientService clientService, ClientRepository clientRepository, IMapper mapper) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @Override
    public ClientViewModel getById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        return mapper.map(client, ClientViewModel.class);
    }

    @Override
    public List<ClientViewModel> getAll() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream()
            .map(client -> mapper.map(client, ClientViewModel.class))
            .collect(Collectors.toList());
    }

    @Override
    public void create(ClientViewModel clientViewModel) {
        Client client = mapper.map(clientViewModel, Client.class);
        clientService.create(client);
    }

    @Override
    public void update(ClientViewModel clientViewModel) {
        Client client = mapper.map(clientViewModel, Client.class);
        clientService.update(client);
    }

    @Override
    public void delete(Long id) throws Exception {
        clientService.delete(id);
    }
    
}
