package com.vespertino.hotelvesp.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="quarto")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 10, nullable = false)
    @Pattern(regexp="^[0-9]{1,10}$")
    private Integer id;
    @Column(name="nome", nullable = false, length = 255)
    @Pattern(regexp="^[A-z\s]{1,255}$")
    private String nome;
    @Column(name="numero", nullable = false, length = 10)
    @Pattern(regexp="^[0-9]{1,10}$")
    private Integer numero;
    @Column(name="diaria", nullable = false, length = 9)
    @Pattern(regexp="^[0-9]{1,9}[.,][0-9]{1,2}$")
    private Double diaria;
    @Column(name="capacidade", nullable = false, length = 4)
    @Pattern(regexp = "^[0-1][0-9]$")
    private Integer capacidade;
    @Column(name="area_quarto", nullable = false, length = 8)
    @Pattern(regexp = "^[0-9]{1,3}[.,][0-9]{1,2}$")
    private Double areaQuarto;
    @Column(name="ativo")
    @Pattern(regexp = "^true$|^false$")
    private Boolean ativo;
    @Column(name="id_andar", length = 10, nullable = false)
    @Pattern(regexp="^[0-9]{1,10}$")
    private Integer idAndar;
    @Column(name="id_funcionario", length = 10, nullable = false)
    @Pattern(regexp="^[0-9]{1,10}$")
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

    public Double getDiaria() {
        return diaria;
    }

    public void setDiaria(Double diaria) {
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
