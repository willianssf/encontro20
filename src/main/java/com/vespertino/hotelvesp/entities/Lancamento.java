package com.vespertino.hotelvesp.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table (name="lancamento")
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 10, nullable = false)
    @Pattern(regexp="[0-9]{1,10}]")
    private Integer id;

    @Column(name="debito", length = 18, nullable = false)
    @Pattern(regexp="^[0-9]{1,15}[.][0-9]{1,2}$")
    private Double debito;

    @Column(name="adicional", length = 18, nullable = false)
    @Pattern(regexp="^[0-9]{1,15}[.][0-9]{1,2}$")
    private Double adicional;

    @Column(name="ativo", length = 1, nullable = false)
    @Pattern(regexp="^[0-1]$")
    private Boolean ativo;


    @Column(name="id_funcionario", nullable = false, unique = true, length = 10)
    @Pattern(regexp = "[0-9]{10}")
    private Integer idFuncionario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDebito() {
        return debito;
    }

    public void setDebito(Double debito) {
        this.debito = debito;
    }

    public Double getAdicional() {
        return adicional;
    }

    public void setAdicional(Double adicional) {
        this.adicional = adicional;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
