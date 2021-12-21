package com.vespertino.hotelvesp.business;

import com.vespertino.hotelvesp.entities.Hospede;
import com.vespertino.hotelvesp.entities.Quarto;
import com.vespertino.hotelvesp.repositories.HospedeRepository;
import com.vespertino.hotelvesp.repositories.QuartoRepository;

import java.util.ArrayList;
import java.util.List;

public class HospedeBiz {

    private QuartoRepository quartoRepository;
    private Hospede hospede;
    private HospedeRepository hospedeRepository;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public HospedeBiz(Hospede hospede, HospedeRepository hospedeRepository){
        this.hospede = hospede;
        this.hospedeRepository = hospedeRepository;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado = telefone11Numero(this.hospede.getTelefone());
        resultado = nomePreenchido(this.hospede.getNome()) && resultado;
        resultado = nomeAtendeCaracteres(this.hospede.getNome()) && resultado;
        resultado = emailPreenchido(this.hospede.getEmail()) && resultado;
        resultado = limiteCredito0a1000000(this.hospede.getLimite_credito()) && resultado;

        return resultado;
    }

    public Boolean telefone11Numero (String telefone){
        Boolean resultado  = telefone.matches("^[0-9]{11}$");
        if (!resultado){
            erros.add("O telegone nao possuo 11 numeros!");
        }
        return resultado;

    }

    public Boolean nomePreenchido (String nome){
        Boolean resultado = nome.matches("^[A-z\s]{1,}$");
        if (!resultado){
            erros.add("O nome nao pode estar vazio");
        }
        return resultado;
    }
    public Boolean nomeAtendeCaracteres (String nome){
        Boolean resultado = nome.matches("^[A-z\s]{10,50}$");
        if (!resultado){
            erros.add("O nome deve ter entre 10 e 50 caracteres");
        }
        return resultado;
    }
    public Boolean emailPreenchido(String email){
        Boolean resultado = !email.isEmpty();
        if (!resultado){
            erros.add("O email nao pode estar vazio");
        }
        return resultado;
    }
    public Boolean limiteCredito0a1000000 (Double limiteCredito){
        Boolean resultado = limiteCredito.doubleValue() < 1000000 && limiteCredito.doubleValue() > 0;
        if (!resultado){
            erros.add("O limite de credito deve estar acima de zero e abaixo de 1000000!");
        }
        return resultado;
    }
    //public Boolean quartoExiste( Integer idquarto ) {
       // Quarto lista = quartoRepository.findById(idquarto).stream();
       // Boolean resultado = !lista.equals();
        //if (!resultado) {
         //   erros.add("Quarto não existe!");
       // }
       // return resultado;
    //}

}
