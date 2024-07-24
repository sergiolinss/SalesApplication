package io.github.sergiolinss.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Integer id;
    private String nome;
    @Column(length = 11)
    private String cpf;
    @JsonIgnore // propriedade ignorada nos arquivos JSON
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY) // buscamos os pedidos a partir da tabela de clientes
    private Set<Pedido> pedidos; // lista de pedidos

    /* quando criamos um construtor para uma entidade em JPA, é necessário que definamos o construtor padrão explicitamente
    pois ele não é mais provido automaticamente ou utilizamos o lombok NoArgsConstructor */

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
