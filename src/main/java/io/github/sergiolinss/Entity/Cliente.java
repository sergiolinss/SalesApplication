package io.github.sergiolinss.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

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
    pois ele não é mais provido automaticamente */
    public Cliente() {
    }

    public Cliente(Integer id,String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
