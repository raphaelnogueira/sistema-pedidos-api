package br.com.pedidos.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.domain.interfaces.repositories.ProductRepository;
import br.com.pedidos.domain.interfaces.services.IProductService;
import br.com.pedidos.domain.models.Product;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void create(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) throws Exception {
        productRepository.deleteById(id);
    }
    
}
