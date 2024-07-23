package io.github.sergiolinss.Service.Impl;


import io.github.sergiolinss.Repository.RepositorioPedidos;
import io.github.sergiolinss.Repository.RepositorioProdutos;
import io.github.sergiolinss.Service.PedidosService;
import org.springframework.stereotype.Service;

@Service
public class PedidosServiceImpl implements PedidosService {

    private RepositorioPedidos repositorioPedidos;

    public PedidosServiceImpl(RepositorioPedidos repositorioPedidos) {
        this.repositorioPedidos = repositorioPedidos;
    }
}
