package br.com.pedidos.services.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.application.interfaces.IProductAppService;
import br.com.pedidos.application.viewmodels.ProductViewModel;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private IProductAppService productAppService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductViewModel> getById(@PathVariable("id") Long id) {
        if(id == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        try {
            ProductViewModel productViewModel = productAppService.getById(id);
            if(productViewModel == null) { 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(productViewModel);   
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductViewModel>> getAll() {
        List<ProductViewModel> productsViewModel = productAppService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(productsViewModel);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProductViewModel productViewModel) {
        try {
            productAppService.create(productViewModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ProductViewModel productViewModel) {
        try {
            productAppService.update(productViewModel);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            productAppService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
