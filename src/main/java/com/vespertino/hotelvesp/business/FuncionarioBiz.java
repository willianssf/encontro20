package com.vespertino.hotelvesp.business;

import com.vespertino.hotelvesp.entities.Funcionario;
import com.vespertino.hotelvesp.repositories.FuncionarioRepository;
import com.vespertino.hotelvesp.repositories.LancamentoRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FuncionarioBiz {
    // tem que ter um metodo chamado isValid
    private Funcionario funcionario;
    private FuncionarioRepository funcionarioRepository;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public FuncionarioBiz(Funcionario funcionario, FuncionarioRepository fr){
        this.funcionario = funcionario;
        this.funcionarioRepository = fr;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado = nomeNaoExiste(this.funcionario.getNome());
        resultado =  emailNaoExiste(this.funcionario.getEmail()) && resultado;
        resultado =  primeiraLetraMaiuscula(this.funcionario.getNome()) && resultado;
        resultado =  salarioAcimaDe1100(this.funcionario.getSalario()) && resultado;
        resultado =  nomeNaoVazio(this.funcionario.getNome()) && resultado;
        resultado =  emailNaoVazio(this.funcionario.getEmail()) && resultado;
        resultado = verificadorTelefone(this.funcionario.getTelefone()) && resultado;

        return resultado;
    }
    // o nome nao pode existir no banco de dados (nao pode ter nome repetido)
    public Boolean nomeNaoExiste( String nome ){
        List<Funcionario> lista = funcionarioRepository.findByNome(nome);
        Boolean resultado = lista.isEmpty();
        if (!resultado){
            erros.add("O nome já existe no banco de dados");
        }
        return resultado;
    }
    // O email não pode existir no banco de dados
    public Boolean emailNaoExiste( String email ){
        List<Funcionario> lista = funcionarioRepository.findByEmail(email);
        Boolean resultado = lista.isEmpty();
        if (!resultado){
            erros.add("O email já existe no banco de dados");
        }
        return resultado;
    }
    // a primaira letra tem que ser maiuscula
    public Boolean primeiraLetraMaiuscula(String nome){
        Boolean resultado  =nome.matches("^[A-Z]{1}[A-Za-z\s]{1,50}");
        if (!resultado){
            erros.add("O nome precisa ter a primeira letra maiuscula");
        }
        return resultado;
    }
    // o salario deve ser acima de 1100
    public Boolean salarioAcimaDe1100( BigDecimal salario ){
        Boolean resultado = salario.doubleValue() >= 1100;
        if (!resultado){
            erros.add("O Salario deve ser maior ou igual a 1100");
        }
        return resultado;
    }
    // o nome não pode ser vazio
    public Boolean nomeNaoVazio (String nome) {
        Boolean resultado = nome != null;
        if (!resultado) {
            erros.add("Não pode nome vazio");
        }
        return resultado;
    }
    // o email nao pode ser vazio
    public Boolean emailNaoVazio (String email) {
        Boolean resultado = email != null;
        if (!resultado) {
            erros.add("Não pode email vazio");
        }
        return resultado;
    }
    // O telefone tem que ter 11 caracteres exatamente
    public Boolean verificadorTelefone (String telefone) {
        Boolean resultado = telefone.matches("^[0-9]{11}$");
        if (!resultado) {
            erros.add("Telefone invalido");
        }
        return resultado;
    }
}
