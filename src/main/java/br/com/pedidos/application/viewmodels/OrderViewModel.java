package br.com.pedidos.application.viewmodels;

import java.util.Date;
import java.util.List;

public class OrderViewModel {
    private Long id;
    private Date createdAt;
    private ClientViewModel client;
    private List<OrderItemViewModel> itens;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public List<OrderItemViewModel> getItens() {
        return itens;
    }

    public void setItens(List<OrderItemViewModel> itens) {
        this.itens = itens;
    }

    public ClientViewModel getClient() {
        return client;
    }

    public void setClient(ClientViewModel client) {
        this.client = client;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
