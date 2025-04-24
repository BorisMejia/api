package com.pedidos.api.service;

import com.pedidos.api.model.Pedido;
import com.pedidos.api.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepo;


    @Override
    public List<Pedido> findAll() {
        return pedidoRepo.findAll();
    }
    @Override
    public Optional<Pedido> findById(Integer id) {
        return pedidoRepo.findById(id);
    }
    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepo.save(pedido);
    }

    @Override
    public Pedido update(Integer id, Pedido pedido) {
        Pedido exist = pedidoRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido no encontrado" + id));

        exist.setNombrePedido(pedido.getNombrePedido());
        exist.setCategoria(pedido.getCategoria());
        exist.setDescripcion(pedido.getDescripcion());
        return pedidoRepo.save(exist);
    }
    @Override
    public void delete(Integer id) {
        if (!pedidoRepo.existsById(id)){
            throw new EntityNotFoundException("Pedido no encontrado");
        }
        pedidoRepo.deleteById(id);
    }
}
