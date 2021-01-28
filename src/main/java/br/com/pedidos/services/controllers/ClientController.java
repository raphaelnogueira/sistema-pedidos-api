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

import br.com.pedidos.application.interfaces.IClientAppService;
import br.com.pedidos.application.viewmodels.ClientViewModel;

@RestController
@RequestMapping(value = "clients")
public class ClientController {

    @Autowired
    private IClientAppService clientAppService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientViewModel> getById(@PathVariable("id") Long id) {
        if(id == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        try {
            ClientViewModel clientViewModel = clientAppService.getById(id);
            if(clientViewModel == null) { 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(clientViewModel);   
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping //alguma.com.br/clients
    public ResponseEntity<List<ClientViewModel>> getAll() {
        List<ClientViewModel> clientsViewModel = clientAppService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(clientsViewModel);
    }

    @PostMapping //alguma.com.br/clients
    public ResponseEntity<String> create(@RequestBody ClientViewModel clientViewModel) {
        try {
            clientAppService.create(clientViewModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ClientViewModel clientViewModel) {
        try {
            clientAppService.update(clientViewModel);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}") //clients/1
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            clientAppService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
}
