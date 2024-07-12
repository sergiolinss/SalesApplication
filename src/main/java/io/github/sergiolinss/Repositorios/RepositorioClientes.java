package io.github.sergiolinss.Repositorios;

import io.github.sergiolinss.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioClientes extends JpaRepository<Cliente, Integer> {
    // Métodos CRUD padrão são herdados de JpaRepository
    // Métodos personalizados podem ser adicionados aqui, se necessário
    @Query("select c from Cliente c where c.nome like %:nome%")
    List<Cliente> findByNome(String nome);

    boolean existsByNome(String nome);
    @Modifying
    @Query("delete from Cliente c where c.nome =:nome ")
    void deleteByNome(String nome);


}
