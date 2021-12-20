package com.vespertino.hotelvesp.entities;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Entity
@Table(name="funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true, length = 10)
    @Pattern(regexp="[A-z0-9\s]{1,10}")
    private Integer id;
    @Column(name="nome", nullable = false, length = 255)
    @Pattern(regexp="[A-z\s]{1,255}")
    private String nome;
    @Column(name="email", nullable = false, unique = true, length = 255)
    @Pattern(regexp ="[A-z]{1,64}@[A-Za-z0-9]{1,255}.[A-z]{1,3}" )
    private String email;
    @Column(name="telefone", nullable = false, unique = true, length = 255)
    @Pattern(regexp = "[0-9]{2}[\\s][0-9]{5}-[0-9]{4}")
    private String telefone;
    @Column(name="salario", nullable = false, length = 15)
    @Pattern(regexp = "[0-9]{1,15}[.][0-9]{1,2}")
    private BigDecimal salario;
    @Column(name="cargo", nullable = false, length = 255)
    @Pattern(regexp = "[A-z\s]{1,255}]")
    private String cargo;
    @Column(name="ativo", nullable = false)
    @Pattern(regexp = "(?i)(true|false)")
    private Boolean ativo;
    @Column(name="id_lancamento", nullable = false, unique = true, length = 10)
    @Pattern(regexp = "[0-9]{10}")
    private Integer idLancamento;

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

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(Integer idLancamento) {
        this.idLancamento = idLancamento;
    }
}
