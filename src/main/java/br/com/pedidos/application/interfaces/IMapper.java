package br.com.pedidos.application.interfaces;

public interface IMapper {
    public <D> D map(Object source, Class<D> destinationType);
}
