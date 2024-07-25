package io.github.sergiolinss.Controller;

import io.github.sergiolinss.DTOs.PedidoDTO;
import io.github.sergiolinss.Entity.Pedido;
import io.github.sergiolinss.Service.PedidosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private PedidosService service;

    public PedidosController(PedidosService service) {
        this.service = service;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer saveProduto (PedidoDTO pedidoDTO){
        Pedido pedido = service.salvar(pedidoDTO);
        return pedido.getId();
    }
}
