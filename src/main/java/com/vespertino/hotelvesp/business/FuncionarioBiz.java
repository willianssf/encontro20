package com.vespertino.hotelvesp.business;

import com.vespertino.hotelvesp.entities.Funcionario;
import com.vespertino.hotelvesp.repositories.FuncionarioRepository;

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
        resultado =  primeiraLetraMaiuscula(this.funcionario.getNome()) && resultado;
        resultado =  salarioAcimaDe1100(this.funcionario.getSalario()) && resultado;


        return resultado;
    }

    // o nome nao pode existir no banco de dados (nao pode ter nome repetido
    // a primaira letra tem que ser maiuscula
    // o salario deve ser acima de 1100
    // o nome deve ter entre 10 e 50 caracteres

    // o email nao pode ser vazio


    public Boolean nomeNaoExiste( String nome ){
        List<Funcionario> lista = funcionarioRepository.findByNome(nome);
        Boolean resultado = lista.isEmpty();
        if (!resultado){
            erros.add("O nome já existe no banco de dados");
        }
        return resultado;
    }

    public Boolean primeiraLetraMaiuscula(String nome){

        Boolean resultado  =nome.matches("^[A-Z]{1}[A-Za-z\s]{1,50}");
        if (!resultado){
            erros.add("O nome precisa ter a primeira letra maiuscula");
        }
        return resultado;
    }

    public Boolean salarioAcimaDe1100( BigDecimal salario ){
        Boolean resultado = salario.doubleValue() >= 1100;

        if (!resultado){
            erros.add("O Salario deve ser maior ou igual a 1100");
        }
        return resultado;
    }



}
