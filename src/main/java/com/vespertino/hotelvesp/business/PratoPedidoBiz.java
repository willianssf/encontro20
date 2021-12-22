package com.vespertino.hotelvesp.business;
import com.vespertino.hotelvesp.entities.Funcionario;
import com.vespertino.hotelvesp.entities.PratoPedido;
import com.vespertino.hotelvesp.repositories.FuncionarioRepository;
import com.vespertino.hotelvesp.repositories.PedidoRepository;
import com.vespertino.hotelvesp.repositories.PratoPedidoRepository;
import com.vespertino.hotelvesp.entities.Prato;
import com.vespertino.hotelvesp.repositories.PratoRepository;
import java.util.ArrayList;
import java.util.List;

//o id do prato tem que existir na tabela prato
//o id do pedido tem que existir na tabela pedido

public class PratoPedidoBiz {
    private PratoPedido pratoPedido;
    private PratoPedidoRepository pratoPedidoRepository;
    private List<String> erros;
    private PratoRepository pratoRepository;
    private PedidoRepository pedidoRepository;

    public PratoPedidoBiz(PratoPedido pratoPedido, PratoPedidoRepository pratoPedidoRepository,
                          PratoRepository pratoRepository, PedidoRepository pedidoRepository){
        this.pratoPedido = pratoPedido;
        this.pratoPedidoRepository = pratoPedidoRepository;
        this.erros = new ArrayList<>();
        this.pratoRepository = pratoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public Boolean isValid(){
        Boolean resultado = idPratoExisteTabelaPrato(this.pratoPedido.getIdPrato());
        resultado = idPedidoExisteTabelaPedido(this.pratoPedido.getIdPedido()) && resultado;
        return resultado;
    }

    public Boolean idPratoExisteTabelaPrato(Integer id ){

        Boolean vazio = pratoRepository.findById(id).isEmpty();
        if(vazio) {
            erros.add("O prato não está na lista");
            return false;
        } else {
            return true;
        }
    }

    public Boolean idPedidoExisteTabelaPedido(Integer id ){

        Boolean vazio = pedidoRepository.findById(id).isEmpty();
        if(vazio) {
            erros.add("O pedido não está na lista");
            return false;
        } else {
            return true;
        }
    }

}