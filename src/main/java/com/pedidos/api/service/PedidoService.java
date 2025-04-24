package com.pedidos.api.service;


import com.pedidos.api.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService
{

    List<Pedido> findAll();

    Optional<Pedido> findById(Integer id);

    Pedido save(Pedido pedido);

    Pedido update(Integer id, Pedido pedido);

    void delete(Integer id);



}
