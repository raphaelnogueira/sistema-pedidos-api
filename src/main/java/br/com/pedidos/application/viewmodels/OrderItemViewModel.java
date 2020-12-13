package br.com.pedidos.application.viewmodels;

public class OrderItemViewModel {

    private Integer quantity;
    private ProductViewModel product;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductViewModel getProduct() {
        return product;
    }

    public void setProduct(ProductViewModel product) {
        this.product = product;
    }

    
}
