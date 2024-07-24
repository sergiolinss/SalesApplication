package io.github.sergiolinss.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @ManyToOne // muitos itens pedidos para um pedido
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @ManyToOne // muitos itens pedidos para um produto
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private Integer quantidade;

}
