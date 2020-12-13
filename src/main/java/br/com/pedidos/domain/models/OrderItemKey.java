package br.com.pedidos.domain.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderItemKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "product_id")
    Long productId;

    @Column(name = "order_id")
    Long orderId;
    
}
