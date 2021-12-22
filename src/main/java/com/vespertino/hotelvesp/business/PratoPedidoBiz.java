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
        Boolean resultado = idPratoNaoExiste(this.pratoPedido.getIdPrato());
        resultado = idPedidoNaoExiste(this.pratoPedido.getIdPedido()) && resultado;

        return resultado;
    }

    public Boolean idPratoNaoExiste(Integer id ){
        List<PratoPedido> lista = pratoPedidoRepository.findByIdPrato(id);
        if(lista.isEmpty()) {
            erros.add("O prato não está na lista");
            return false;
        }
        if (!idPratoAtivo(id)){
            erros.add("O prato não está na lista");
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean idPratoAtivo(Integer id){
        Boolean pratoExiste = pratoRepository.findById(id).get().getAtivo();

       return pratoExiste;
    }

    public Boolean idPedidoNaoExiste(Integer id ){
        List<PratoPedido> lista = pratoPedidoRepository.findByIdPedido(id);
        if(lista.isEmpty()) {
            erros.add("O pedido não está na lista");
            return false;
        }
        if (!idPedidoAtivo(id)){
            erros.add("O pedio não está na lista");
            return false;
        }
        else {
            return true;
        }

    }

    public Boolean idPedidoAtivo(Integer id){
        Boolean pedidoExiste = pedidoRepository.findById(id).get().getAtivo();

        return pedidoExiste;
    }

}