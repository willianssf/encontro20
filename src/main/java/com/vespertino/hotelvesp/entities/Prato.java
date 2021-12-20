package com.vespertino.hotelvesp.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name ="prato")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    @Pattern(regexp = "[0-9]{1,10}")
    private Integer id;

    @Column(name = "nome", length = 255,nullable = false)
    @Pattern(regexp = "[A-z\s]{1,255}")
    private String nome;

    @Column(name = "valor",length = 18,nullable = false )
    @Pattern(regexp="^[0-9]{1,15}[.][0-9]{1,2}$")
    private Double valor;

    @Column(name = "ativo",nullable = false)
    @Pattern(regexp = "^true$|^false$")
    private Boolean ativo;

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
