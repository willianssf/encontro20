package com.vespertino.hotelvesp.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

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
    private BigDecimal debito;

    @Column(name="adicional", length = 18, nullable = false)
    @Pattern(regexp="^[0-9]{1,15}[.][0-9]{1,2}$")
    private BigDecimal adicional;

    @Column(name="ativo", length = 1, nullable = false)
    @Pattern(regexp="^[0-1]$")
    private Boolean ativo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getDebito() {
        return debito;
    }

    public void setDebito(BigDecimal debito) {
        this.debito = debito;
    }

    public BigDecimal getAdicional() {
        return adicional;
    }

    public void setAdicional(BigDecimal adicional) {
        this.adicional = adicional;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
