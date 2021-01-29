package br.com.pedidos.application.interfaces;

import java.util.List;

import br.com.pedidos.application.viewmodels.OrderViewModel;

public interface IOrderAppService {
    OrderViewModel getById(Long id);
    List<OrderViewModel> getAll();
    List<OrderViewModel> getByClientCpf(String cpf);
    void create(OrderViewModel orderViewModel);
    void deleteAll();    
}
