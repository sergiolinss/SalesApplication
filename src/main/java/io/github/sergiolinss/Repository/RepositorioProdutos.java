package io.github.sergiolinss.Repository;

import io.github.sergiolinss.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProdutos extends JpaRepository<Produto, Integer> {
}
