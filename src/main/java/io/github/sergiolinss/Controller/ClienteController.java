package io.github.sergiolinss.Controller;

import io.github.sergiolinss.Entity.Cliente;
import io.github.sergiolinss.Repository.RepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/clientes") // definimos a URL
public class ClienteController {


    private RepositorioClientes repositorioClientes;
    @Autowired
    public ClienteController(RepositorioClientes repositorioClientes){
        this.repositorioClientes = repositorioClientes;
    }

    @GetMapping("/{id}") // extensão a URL para acessarmos este método
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id){
        Optional<Cliente> cliente = repositorioClientes.findById(id);

        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    @ResponseBody
    public ResponseEntity saveCliente(@RequestBody Cliente clientes){
       Cliente clienteSalvo = repositorioClientes.save(clientes);
       return ResponseEntity.ok(clienteSalvo);
    }
}
