package com.vespertino.hotelvesp.business;


import com.vespertino.hotelvesp.entities.Pedido;

import com.vespertino.hotelvesp.entities.Quarto;
import com.vespertino.hotelvesp.repositories.PedidoRepository;
import com.vespertino.hotelvesp.repositories.QuartoRepository;


import java.util.ArrayList;
import java.util.List;

public class PedidoBiz {
    private Pedido pedido;
    private PedidoRepository pedidoRepository;
    private QuartoRepository quartoRepository;
    private List<String> erros;
    List<Quarto> list = quartoRepository.findByAtivo(true);


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
      Boolean resultado = preco > 0 && preco < 500 ;
      if(!resultado)
      {
          erros.add("Preço invalido");
      }
      return resultado;
    }
    public Boolean verificarQuarto(Integer id){
        List<Pedido> lista = pedidoRepository.findByIdQuarto(id);



        Boolean resultado = list.contains(lista.contains(id));
        Boolean resulta2 = lista.isEmpty();

        if (!resultado){
            erros.add("Quarto não existe");
        }
        return !resultado;
    }


}
