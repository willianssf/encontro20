package com.vespertino.hotelvesp.business;

import com.vespertino.hotelvesp.entities.Funcionario;
import com.vespertino.hotelvesp.entities.PratoPedido;
import com.vespertino.hotelvesp.repositories.FuncionarioRepository;
import com.vespertino.hotelvesp.repositories.PedidoRepository;
import com.vespertino.hotelvesp.repositories.PratoPedidoRepository;

import java.util.ArrayList;
import java.util.List;

public class PratoPedidoBiz {


    private PratoPedido pratoPedido;
    private PratoPedidoRepository pratoPedidoRepository;
    private List<String> erros;



    public PratoPedidoBiz(PratoPedido pratoPedido, PratoPedidoRepository pratoPedidoRepository){
        this.pratoPedido = pratoPedido;
        this.pratoPedidoRepository = pratoPedidoRepository;
        this.erros = new ArrayList<>();
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public Boolean isValid(){
        Boolean resultado = idPratoNaoExiste(this.pratoPedido.getIdPrato());
        resultado = idPedidoNaoExiste(this.pratoPedido.getIdPedido()) && resultado;

        return resultado;
    }


    //o id do prato tem que existir na tabela prato
    //o id do pedido tem que existir na tabela pedido

    public Boolean idPratoNaoExiste(Integer id ){
        List<PratoPedido> lista = pratoPedidoRepository.findByIdPrato(id);
        Boolean resultadoVazio = lista.isEmpty();
        Boolean resultado = lista.contains(id);

        if(!resultado && resultadoVazio) {
            erros.add("O prado não está na lista");
        }
     return resultado;
    }

    public Boolean idPedidoNaoExiste(Integer id ){
        List<PratoPedido> lista = pratoPedidoRepository.findByIdPedido(id);
        Boolean resultadoVazio = lista.isEmpty();
        Boolean resultado = lista.contains(id);

        if(!resultado && resultadoVazio) {
            erros.add("O pedido não está na lista");
        }

        return resultado;
    }

}
