package io.github.sergiolinss.Controller;

import io.github.sergiolinss.Entity.Cliente;
import io.github.sergiolinss.Repository.RepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes") // definimos a URL
public class ClienteController {

    private RepositorioClientes repositorioClientes;

    public ClienteController(RepositorioClientes repositorioClientes){
        this.repositorioClientes = repositorioClientes;
    }

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id){
        Optional<Cliente> cliente = RepositorioClientes.findById(id);
        if (cliente.isPresent()){
            HttpHeaders headers = new HttpHeaders();
            headers.put("Authorization", "token");
            ResponseEntity<Cliente> responseEntity =
                    new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        }
    }
}
