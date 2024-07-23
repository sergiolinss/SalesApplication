package io.github.sergiolinss.Controller;

import io.github.sergiolinss.Service.PedidosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private PedidosService service;

    public PedidosController(PedidosService service) {
        this.service = service;
    }
}
