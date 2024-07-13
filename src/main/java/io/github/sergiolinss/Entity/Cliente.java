package io.github.sergiolinss.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY) // buscamos os pedidos a partir da tabela de clientes
    private Set<Pedido> pedidos; // lista de pedidos

    /* quando criamos um construtor para uma entidade em JPA, é necessário que definamos o construtor padrão explicitamente
    pois ele não é mais provido automaticamente */
    public Cliente() {
    }

    public Cliente(String nome) {
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

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
