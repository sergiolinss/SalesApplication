package io.github.sergiolinss.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @ManyToOne // muitos pedidos para um cliente
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private LocalDate dataPedido;
    @Column(precision = 20, scale = 2) // até 20 dígitos, no máximo 2 casas decimais
    private BigDecimal totalPedido;
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;


}
