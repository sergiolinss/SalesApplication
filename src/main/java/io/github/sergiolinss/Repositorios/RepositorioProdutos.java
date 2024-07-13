package io.github.sergiolinss.Repositorios;

import io.github.sergiolinss.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProdutos extends JpaRepository<Produto, Integer> {
}
