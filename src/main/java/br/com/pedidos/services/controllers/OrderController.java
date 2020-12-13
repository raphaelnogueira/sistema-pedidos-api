package br.com.pedidos.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.application.interfaces.IOrderAppService;
import br.com.pedidos.application.viewmodels.OrderViewModel;

@RestController
@RequestMapping(value = "orders")
public class OrderController {

    @Autowired
    private IOrderAppService orderAppService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderViewModel orderViewModel) {
        try {
            orderAppService.create(orderViewModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
}
