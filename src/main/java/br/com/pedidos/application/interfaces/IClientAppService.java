package br.com.pedidos.application.interfaces;

import java.util.List;

import br.com.pedidos.application.viewmodels.ClientViewModel;

public interface IClientAppService {
    ClientViewModel getById(Long id);
    List<ClientViewModel> getAll();
    void create(ClientViewModel clientViewModel) throws Exception;
    void update(ClientViewModel clientViewModel);
    void delete(Long id) throws Exception;
}
