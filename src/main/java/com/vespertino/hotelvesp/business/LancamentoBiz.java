package com.vespertino.hotelvesp.business;

import com.vespertino.hotelvesp.entities.Hospede;
import com.vespertino.hotelvesp.entities.Lancamento;
import com.vespertino.hotelvesp.repositories.HospedeRepository;
import com.vespertino.hotelvesp.repositories.LancamentoRepository;
import com.vespertino.hotelvesp.repositories.QuartoRepository;

import java.util.ArrayList;
import java.util.List;

public class LancamentoBiz {

    private Lancamento lancamento;
    private LancamentoRepository lancamentoRepository;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public LancamentoBiz(Lancamento lancamento, LancamentoRepository lancamentoRepository){
        this.lancamento = lancamento;
        this.lancamentoRepository = lancamentoRepository;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado = lancametoCreditoPositvo(this.lancamento.getAdicional(),this.lancamento.getDebito());

        return resultado;
    }

    public Boolean lancametoCreditoPositvo( Double lancamentoCredito, Double lancamentoDebito){
        Boolean resultadoCredito  = lancamentoCredito.doubleValue()>=1;
        Boolean resultadoDebito  = lancamentoDebito.doubleValue()>=1;

        if (!resultadoCredito || !resultadoDebito){
            erros.add("Credito ou debito devem ter valores positivos");
        }
        return resultadoCredito || resultadoDebito;


    }
}
