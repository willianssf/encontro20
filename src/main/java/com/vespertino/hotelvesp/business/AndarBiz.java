package com.vespertino.hotelvesp.business;

import com.vespertino.hotelvesp.entities.Andar;
import com.vespertino.hotelvesp.entities.Funcionario;
import com.vespertino.hotelvesp.repositories.AndarRepository;
import com.vespertino.hotelvesp.repositories.FuncionarioRepository;

import java.util.ArrayList;
import java.util.List;

public class AndarBiz {

    private Andar andar;
    private AndarRepository andarRepository;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public AndarBiz(Andar andar, AndarRepository ar){
        this.andar = andar;
        this.andarRepository = ar;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado = andarValido(this.andar.getNivel());
        resultado = capacidadeDeQuartos(this.andar.getCapacidadeQuarto()) && resultado;



        return resultado;
    }

    public Boolean andarValido( String nivel ){

        Boolean resultado  = nivel.matches("^[1-9]{1}[A-z0-9\s]{1,}");
        if (!resultado){
            erros.add("O nivel deve ser maior que 0");
        }
        return resultado;
    }
    public Boolean capacidadeDeQuartos( Integer capacidadeQuarto ){

        Boolean resultado  = capacidadeQuarto.intValue()>=1 && capacidadeQuarto.intValue() <=5;
        if (!resultado){
            erros.add("A capacidade do quarto deve estar entre 1 a 5");
        }
        return resultado;
    }
}
