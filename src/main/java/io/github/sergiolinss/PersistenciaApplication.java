package io.github.sergiolinss;

import io.github.sergiolinss.Entity.Cliente;
import io.github.sergiolinss.Entity.Pedido;
import io.github.sergiolinss.Repository.RepositorioClientes;
import io.github.sergiolinss.Repository.RepositorioPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class PersistenciaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersistenciaApplication.class, args);
    }

    @Autowired
    private RepositorioClientes repositorioClientes;

    @Bean
    public CommandLineRunner teste(
            @Autowired RepositorioPedidos pedidos) { // ao injetarmos @Autowired como parâmetro, não precisamos sempre chamar a o repositório ao usar uma função
        return (args) -> {
            System.out.println(" SALVANDO CLIENTES ");
            Cliente cliente1 = new Cliente("Sérgio");
            Cliente cliente2 = new Cliente("Carlos");
            repositorioClientes.save(cliente1);
            repositorioClientes.save(cliente2);
            List<Cliente> clientesList = repositorioClientes.findAll();
            clientesList.forEach(System.out::println);

            System.out.println("SALVANDO PEDIDOS");
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente1);
            pedido.setDataPedido(LocalDate.now());
            pedido.setTotalPedido(BigDecimal.valueOf(100.00));
            pedidos.save(pedido); // @Autowired configurado no parâmetro do CommandLineRunner
//            repositorioClientes.findClienteFetchPedidos(cliente1.getId());// usando o @Autowired repositórioClientes clientes como parâmetro do CommandLineRunner, não precisaria chamar o repositório aqui
//            System.out.println(cliente1);
//            System.out.println(cliente1.getPedidos());
            pedidos.findByCliente(cliente1).forEach(System.out::println);

            System.out.println(" ATUALIZANDO CLIENTES ");
            Cliente atualizarCliente = repositorioClientes.findById(2).get();
            atualizarCliente.setNome("Carlos atualizado");
            repositorioClientes.save(atualizarCliente);
            System.out.println(atualizarCliente);

            System.out.println(" ENCONTRANDO CLIENTES PELO NOME ");
            repositorioClientes.findByNome("Car").forEach(System.out::println); // funcionou com parte do nome pois usamos o @Query no findByNome

            boolean exite = repositorioClientes.existsByNome("Sérgio");
            System.out.println("Existe um cliente com o nome Sérgio " + exite);

//            repositorioClientes.deleteAll();
//            clientesList = repositorioClientes.findAll(); // preciso buscar novamente os clientes após serem deletados, se eu usar o findAll da linha 30, os clientes ainda não foram deletados
//            if (clientesList.isEmpty()){
//                System.out.println("Nenhum cliente encontrado");
//            }else{
//                clientesList.forEach(System.out::println);
//            }
        };
    }
}
