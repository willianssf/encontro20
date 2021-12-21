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
        Boolean resultado = verificadorNome(this.prato.getNome());
        resultado = nomeNaoExiste(this.prato.getNome()) && resultado;
        resultado = valorAcima0(this.prato.getValor()) && resultado;
        return resultado;
    }

    /*O nome deve ser maior que 5 e menor que 50
    Não pode ter nome repetido no banco de dados
    O valor deve ser acima de 0*/

    public Boolean verificadorNome (String nome) {
        Boolean resultado = nome.matches("[A-Za-z]{5,50}");
        if (!resultado) {
            erros.add("Nome menor que 5 ou maior que 50");
        }
        return resultado;
    }

    public Boolean nomeNaoExiste (String nome) {
        List<Prato> lista = pratoRepository.findByNome(nome);
        Boolean resultado = lista.isEmpty();
        if (!resultado) {
            erros.add("Este nome ja existe");
        }
        return resultado;
    }

    public Boolean valorAcima0 (Double valor) {
        Boolean resultado = valor > 0;
        if (!resultado) {
            erros.add("Valor não pode ser 0");
        }
        return resultado;
    }
}
