package io.github.sergiolinss.Controller;

import io.github.sergiolinss.Entity.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes") // definimos a URL
public class ClienteController {
    @RequestMapping(value = "/hello/{nome}",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    @ResponseBody
    public String helloCliente(@PathVariable("nome") String nomeCliente, @RequestBody Cliente cliente){
        return String.format("Hello %s ", nomeCliente);
    }
}
