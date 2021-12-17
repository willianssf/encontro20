package com.vespertino.hotelvesp.entities;

import javax.persistence.*;

@Entity
@Table(name = "andar")
public class Andar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nivel")
    private String nivel;

    @Column(name = "capacidade_quarto")
    private Integer capacidadeQuarto;

    @Column(name = "ativo")
    private Boolean ativo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getCapacidadeQuarto() {
        return capacidadeQuarto;
    }

    public void setCapacidadeQuarto(Integer capacidadeQuarto) {
        this.capacidadeQuarto = capacidadeQuarto;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
