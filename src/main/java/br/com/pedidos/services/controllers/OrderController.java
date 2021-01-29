package br.com.pedidos.services.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<OrderViewModel> getById(@PathVariable("id") Long id) {
        if(id == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        try {
            OrderViewModel orderViewModel = orderAppService.getById(id);
            if(orderViewModel == null) { 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(orderViewModel);   
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/clients/{cpf}")
    public ResponseEntity<List<OrderViewModel>> getByClietnCpf(@PathVariable("cpf") String cpf) {
        List<OrderViewModel> ordersViewModel = orderAppService.getByClientCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(ordersViewModel);
    }

    @GetMapping
    public ResponseEntity<List<OrderViewModel>> getAll() {
        List<OrderViewModel> ordersViewModel = orderAppService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(ordersViewModel); 
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderViewModel orderViewModel) {
        try {
            orderViewModel.setId(null);
            orderAppService.create(orderViewModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/all/{code}")
    public ResponseEntity<String> deleteAll(@PathVariable("code") Integer code) {

        if(code.equals(12345)){
            orderAppService.deleteAll();
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    
}
