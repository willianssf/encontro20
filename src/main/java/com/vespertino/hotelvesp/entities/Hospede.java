package com.vespertino.hotelvesp.entities;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Entity
@Table(name="hospede")
public class Hospede {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false, length = 10)
    @Pattern(regexp="^[0-9]{1,10}$")
    private Integer id;
    @Column(name="nome", nullable = false, length = 255)
    @Pattern(regexp="^[A-z]{1,255}$")
    private String nome;
    @Column(name="email", nullable = false, length = 255)
    @Pattern(regexp="^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$")
    private String email;
    @Column(name="telefone", nullable = false, length = 255)
    @Pattern(regexp = "^[0-9]\\d*$")
    private String telefone;
    @Column(name="limite_credito", nullable = false, length = 255)
    @Pattern(regexp = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$")
    private BigDecimal limite_credito;
    @Column(name="id_quarto",nullable = false,length = 10)
    @Pattern(regexp = "^[0-9]{1,10}$")
    private Integer id_quarto;
    @Column(name="ativo", nullable = false)
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
