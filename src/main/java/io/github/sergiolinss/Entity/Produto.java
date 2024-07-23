package io.github.sergiolinss.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "produto") // usamos esta anotação quando a nossa tabela tem um nome diferente da nossa entidade
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false) // essa anotação só é necessária passarmos como parâmetro o nome quando a tabela tem um nome diferente
    private Integer id;
    private String descricao;
    private BigDecimal precoUnitario;

    public Integer getId() {
        return id;
    }
    public Produto(){

    }
    public Produto(Integer id, String descricao, BigDecimal precoUnitario){
        this.id = id;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}
