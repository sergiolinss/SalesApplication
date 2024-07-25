package io.github.sergiolinss.Service;

import io.github.sergiolinss.DTOs.PedidoDTO;
import io.github.sergiolinss.Entity.Pedido;

public interface PedidosService {
    Pedido salvar(PedidoDTO pedidoDTO);
}
