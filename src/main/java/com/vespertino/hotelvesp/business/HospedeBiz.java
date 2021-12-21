package com.vespertino.hotelvesp.business;

import com.vespertino.hotelvesp.entities.Funcionario;
import com.vespertino.hotelvesp.entities.Hospede;
import com.vespertino.hotelvesp.repositories.FuncionarioRepository;
import com.vespertino.hotelvesp.repositories.HospedeRepository;

import java.util.ArrayList;
import java.util.List;

public class HospedeBiz {

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
        return resultado;
    }

    public Boolean telefone11Numero (String telefone){
        Boolean resultado  = telefone.matches("^[0-9]{11}$");
        if (!resultado){
            erros.add("O telegone nao possuo 11 numeros!");
        }
        return resultado;

    }
}
