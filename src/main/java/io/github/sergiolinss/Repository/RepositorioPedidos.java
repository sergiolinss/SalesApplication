package io.github.sergiolinss.Repository;

import io.github.sergiolinss.Entity.Cliente;
import io.github.sergiolinss.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioPedidos extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
