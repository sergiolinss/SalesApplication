package io.github.sergiolinss.Controller;

import io.github.sergiolinss.Entity.Cliente;
import io.github.sergiolinss.Repository.RepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes") // definimos a URL
public class ClienteController {


    private RepositorioClientes repositorioClientes;

    @Autowired
    public ClienteController(RepositorioClientes repositorioClientes) {
        this.repositorioClientes = repositorioClientes;
    }

    @GetMapping("/{id}") // extensão a URL para acessarmos este método
    public Cliente getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = repositorioClientes.findById(id);
        return repositorioClientes.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente clientes) {
        return repositorioClientes.save(clientes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Integer id) {
        if (repositorioClientes.existsById(id)) {
            repositorioClientes.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable Integer id, @RequestBody Cliente clienteToUpdate) {
        Cliente existingCliente = repositorioClientes.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        existingCliente.setNome(clienteToUpdate.getNome());
        existingCliente.setCpf(clienteToUpdate.getCpf());

        repositorioClientes.save(existingCliente);

    }

    @GetMapping
    public List<Cliente> findClientes(Cliente filtroDeCliente) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtroDeCliente, matcher);
        return repositorioClientes.findAll();
    }
}
