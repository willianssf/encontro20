package com.vespertino.hotelvesp.business;


import com.vespertino.hotelvesp.entities.Pedido;

import com.vespertino.hotelvesp.repositories.PedidoRepository;


import java.util.ArrayList;
import java.util.List;

public class PedidoBiz {
    private Pedido pedido;
    private PedidoRepository pedidoRepository;
    private List<String> erros;

    public List<String> getErros(){
        return erros;
    }
    public void setErros(List<String> erros){
        this.erros = erros;
    }
    public PedidoBiz (Pedido p, PedidoRepository pr) {
        this.pedido = p;
        this.pedidoRepository = pr;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid() {
        Boolean resultado = valorDoPedido(this.pedido.getPreco());
        resultado = verificarQuarto(this.pedido.getIdQuarto()) && resultado;
        return resultado;
    }

    public Boolean valorDoPedido(Double preco){
      Boolean resultado = 0 > preco & preco < 500 ;
      if(!resultado)
      {
          erros.add("Preço invalido");
      }
      return resultado;
    }
    public Boolean verificarQuarto(Integer id){
        List<Pedido> lista = pedidoRepository.findByIdQuarto(id);
        Boolean resultado = lista.contains(id);
        if (!resultado){
            erros.add("Quarto não existe");
        }
        return resultado;
    }


}
