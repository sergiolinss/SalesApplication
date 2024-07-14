package io.github.sergiolinss.Repository;

import io.github.sergiolinss.Entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioItensPedido extends JpaRepository<ItemPedido, Integer> {
}
