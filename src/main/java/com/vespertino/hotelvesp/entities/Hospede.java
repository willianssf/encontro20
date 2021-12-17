package com.vespertino.hotelvesp.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="hospede")
public class Hospede {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="email")
    private String email;
    @Column(name="telefone")
    private String telefone;
    @Column(name="limite_credito")
    private BigDecimal limite_credito;
    @Column(name="id_quarto")
    private Integer id_quarto;
    @Column(name="ativo")
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(BigDecimal limite_credito) {
        this.limite_credito = limite_credito;
    }

    public Integer getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(Integer id_quarto) {
        this.id_quarto = id_quarto;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
