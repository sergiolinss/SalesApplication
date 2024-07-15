package io.github.sergiolinss.Repository;

import io.github.sergiolinss.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioClientes extends JpaRepository<Cliente, Integer> {
    // Métodos CRUD padrão são herdados de JpaRepository
    // Métodos personalizados podem ser adicionados aqui, se necessário
    @Query("select c from Cliente c where c.nome like %:nome%")
    List<Cliente> findByNome(String nome);
    //Optional<Cliente> findById(Integer id);

    boolean existsByNome(String nome);
    @Modifying
    @Query("delete from Cliente c where c.nome =:nome ")
    void deleteByNome(String nome);
    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ") // left join busca o cliente tendo pedidos ou não, se fosse somente o join traria o cliente apenas se existir pedidos
    Cliente findClienteFetchPedidos(@Param("id") Integer id);


}
