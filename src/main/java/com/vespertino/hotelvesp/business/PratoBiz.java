package com.vespertino.hotelvesp.business;

import com.vespertino.hotelvesp.entities.Prato;
import com.vespertino.hotelvesp.repositories.PratoRepository;

import java.util.ArrayList;
import java.util.List;

public class PratoBiz {
    private Prato prato;
    private PratoRepository pratoRepository;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public PratoBiz (Prato p, PratoRepository pr) {
        this.prato = p;
        this.pratoRepository = pr;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid() {
        Boolean resultado = true;
        return resultado;
    }

    /*O nome deve ser maior que 5 e menor que 50
    Não pode ter nome repetido no banco de dados
    O valor deve ser acima de 0*/


}
