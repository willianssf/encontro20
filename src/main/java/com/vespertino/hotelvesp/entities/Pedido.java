package com.vespertino.hotelvesp.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name ="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 10, nullable = false)
    @Pattern(regexp = "[0-9]{10}")
    private Integer id;

    @Column(name = "preco", length = 10, nullable = false)
    @Pattern(regexp = "[1-9]\\d*(\\.\\d+)?")
    private Double preco;

    @Column(name = "ativo", nullable = false)
    @Pattern(regexp = "(?i)(true|false)")
    private Boolean ativo;

    @Column(name = "id_quarto", length = 10, nullable = false)
    @Pattern(regexp = "[0-9]{10}")
    private Integer idQuarto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

}
