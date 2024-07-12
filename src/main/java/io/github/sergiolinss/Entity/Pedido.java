package io.github.sergiolinss.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    @Column(length = 20, precision = 2) // até 20 dígitos, no máximo 2 casas decimais
    private BigDecimal totalPedido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }
}
