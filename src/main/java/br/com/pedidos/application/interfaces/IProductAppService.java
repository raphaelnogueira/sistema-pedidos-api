package br.com.pedidos.application.interfaces;

import java.util.List;

import br.com.pedidos.application.viewmodels.ProductViewModel;

public interface IProductAppService {
    ProductViewModel getById(Long id);
    List<ProductViewModel> getAll();
    void create(ProductViewModel productViewModel);
    void update(ProductViewModel productViewModel);
    void delete(Long id) throws Exception;    
}
