package com.vespertino.hotelvesp.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "andar")
public class Andar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    @Pattern(regexp="[0-9]{10}]")
    private Integer id;
    @Column(name = "nivel", nullable = false, unique = true, length = 255)
    @Pattern(regexp="[A-z0-9\s]{1,255}")
    private String nivel;
    @Column(name = "capacidade_quarto", nullable = false, length = 4)
    @Pattern(regexp = "[0-1][0-9]")
    private Integer capacidadeQuarto;
    @Column(name = "ativo", nullable = false, length = 5)
    @Pattern(regexp = "true|false")
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
