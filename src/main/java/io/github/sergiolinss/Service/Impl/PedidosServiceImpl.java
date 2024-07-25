package io.github.sergiolinss.Service.Impl;


import io.github.sergiolinss.DTOs.PedidoDTO;
import io.github.sergiolinss.Entity.Pedido;
import io.github.sergiolinss.Repository.RepositorioClientes;
import io.github.sergiolinss.Repository.RepositorioPedidos;
import io.github.sergiolinss.Repository.RepositorioProdutos;
import io.github.sergiolinss.Service.PedidosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor //declaramos final para tornarmos os repositorios como argumentos obrigatorios para essa anotação criar um construtor.
public class PedidosServiceImpl implements PedidosService {

    private final RepositorioPedidos repositorioPedidos;
    private final RepositorioClientes repositorioClientes;
    private final RepositorioProdutos repositorioProdutos;



    @Override
    public Pedido salvar(PedidoDTO pedidoDTO) {
        Integer idCliente = pedidoDTO.getCliente();
        repositorioClientes.findById(id)
        Pedido pedido = new Pedido();
        pedido.setTotalPedido(pedidoDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());

        return null;

    }
}
