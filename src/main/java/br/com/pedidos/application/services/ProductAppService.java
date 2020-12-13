package br.com.pedidos.application.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.application.interfaces.IMapper;
import br.com.pedidos.application.interfaces.IProductAppService;
import br.com.pedidos.application.viewmodels.ProductViewModel;
import br.com.pedidos.domain.interfaces.repositories.ProductRepository;
import br.com.pedidos.domain.interfaces.services.IProductService;
import br.com.pedidos.domain.models.Product;

@Service
public class ProductAppService implements IProductAppService {

    private IProductService productService;
    private ProductRepository productRepository;
    private IMapper mapper;

    @Autowired
    public ProductAppService(IProductService productService, ProductRepository productRepository, IMapper mapper) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductViewModel getById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return mapper.map(product, ProductViewModel.class);
    }

    @Override
    public List<ProductViewModel> getAll() {
        List<Product> products = productRepository.findAll();

        return products.stream()
            .map(product -> mapper.map(product, ProductViewModel.class))
            .collect(Collectors.toList());
    }

    @Override
    public void create(ProductViewModel productViewModel) {
        Product product = mapper.map(productViewModel, Product.class);
        productService.create(product);
    }

    @Override
    public void update(ProductViewModel productViewModel) {
        Product product = mapper.map(productViewModel, Product.class);
        productService.update(product);
    }

    @Override
    public void delete(Long id) throws Exception {
        productService.delete(id);
    }
    
}
