package com.vespertino.hotelvesp.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="prato_pedido")
public class PratoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 10, nullable = false)
    @Pattern(regexp = "[0-9]{1,10}")
    private Integer id;
    @Column(name="id_prato", length = 10, nullable = false)
    @Pattern(regexp = "[0-9]{1,10}")
    private Integer idPrato;
    @Column(name="id_pedido", length = 10,nullable = false)
    @Pattern(regexp = "[0-9]{1,10}")
    private Integer idPedido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(Integer idPrato) {
        this.idPrato = idPrato;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
}
