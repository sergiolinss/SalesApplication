package io.github.sergiolinss.Repositorios;

import io.github.sergiolinss.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioClientes extends JpaRepository<Cliente, Integer> {
    // Métodos CRUD padrão são herdados de JpaRepository
    // Métodos personalizados podem ser adicionados aqui, se necessário

}
