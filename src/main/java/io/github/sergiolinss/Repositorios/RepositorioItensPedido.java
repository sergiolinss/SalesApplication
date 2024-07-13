package io.github.sergiolinss.Repositorios;

import io.github.sergiolinss.Entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioItensPedido extends JpaRepository<ItemPedido, Integer> {
}
