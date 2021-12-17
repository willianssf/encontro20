package com.vespertino.hotelvesp.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="quarto")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="numero")
    private Integer numero;
    @Column(name="diaria")
    private BigDecimal diaria;
    @Column(name="capacidade")
    private Integer capacidade;
    @Column(name="area_quarto")
    private Double areaQuarto;
    @Column(name="ativo")
    private Boolean ativo;
    @Column(name="id_andar")
    private Integer idAndar;
    @Column(name="id_funcionario")
    private Integer idFuncionario;

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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public BigDecimal getDiaria() {
        return diaria;
    }

    public void setDiaria(BigDecimal diaria) {
        this.diaria = diaria;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Double getAreaQuarto() {
        return areaQuarto;
    }

    public void setAreaQuarto(Double areaQuarto) {
        this.areaQuarto = areaQuarto;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getIdAndar() {
        return idAndar;
    }

    public void setIdAndar(Integer idAndar) {
        this.idAndar = idAndar;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
