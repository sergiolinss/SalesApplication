package io.github.sergiolinss;

import io.github.sergiolinss.Entity.Cliente;
import io.github.sergiolinss.Repositorios.RepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PersistenciaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersistenciaApplication.class, args);
    }

    @Autowired
    private RepositorioClientes repositorioClientes;

    @Bean
    public CommandLineRunner teste(){
        return (args) -> {
            Cliente cliente = new Cliente();
            cliente.setNome("Sérgio");
            repositorioClientes.save(cliente);

            repositorioClientes.findAll().forEach(c -> System.out.println(c.getNome())); //"c -> System.out.println(c.getNome())" é uma lambda
        };
    }
}
