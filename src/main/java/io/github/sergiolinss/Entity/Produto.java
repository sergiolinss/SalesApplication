package io.github.sergiolinss.Entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto") // usamos esta anotação quando a nossa tabela tem um nome diferente da nossa entidade

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false) // essa anotação só é necessária passarmos como parâmetro o nome quando a tabela tem um nome diferente
    private Integer id;
    private String descricao;
    private BigDecimal precoUnitario;

}
