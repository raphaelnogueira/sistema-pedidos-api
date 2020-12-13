package br.com.pedidos.domain.interfaces.services;

import br.com.pedidos.domain.models.Product;

public interface IProductService {
    void create(Product product);
    void update(Product product);
    void delete(Long id) throws Exception;
}
