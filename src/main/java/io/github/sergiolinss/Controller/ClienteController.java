package io.github.sergiolinss.Controller;

import io.github.sergiolinss.Entity.Cliente;
import io.github.sergiolinss.Repository.RepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = repositorioClientes.findById(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity saveCliente(@RequestBody Cliente clientes) {
        Cliente clienteSalvo = repositorioClientes.save(clientes);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteCliente(@PathVariable Integer id) {
        Optional<Cliente> cliente = repositorioClientes.findById(id);

        if (cliente.isPresent()) {
            repositorioClientes.delete(cliente.get());
            return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso"); // usei o status.ok pois o status.NO_CONTENT não retorna String
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity updateCliente(@PathVariable Integer id, @RequestBody Cliente clienteToUpdate){
        Optional<Cliente> optionalCliente = repositorioClientes.findById(id);
       if (optionalCliente.isPresent()){
           Cliente cliente = optionalCliente.get();
           cliente.setNome(clienteToUpdate.getNome());
           Cliente clienteAtualizado = repositorioClientes.save(cliente);
           return ResponseEntity.ok(clienteAtualizado);
       }
       return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity findClientes(Cliente filtroDeCliente){
        ExampleMatcher matcher = ExampleMatcher.
                                    matching().
                                    withIgnoreCase().
                                    withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtroDeCliente, matcher);
        List<Cliente> lista = repositorioClientes.findAll(example);
        return  ResponseEntity.ok(lista);
    }
}
