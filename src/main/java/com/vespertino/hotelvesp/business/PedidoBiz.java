package com.vespertino.hotelvesp.business;


import com.vespertino.hotelvesp.entities.Pedido;

import com.vespertino.hotelvesp.entities.PratoPedido;
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



    public List<String> getErros(){
        return erros;
    }

    public void setErros(List<String> erros){
        this.erros = erros;
    }

    public PedidoBiz (Pedido p, PedidoRepository pr, QuartoRepository qr) {
        this.pedido = p;
        this.pedidoRepository = pr;
        this.quartoRepository = qr;
        this.erros = new ArrayList<>();
    }

    public Boolean isValid() {
        Boolean resultado = valorDoPedido(this.pedido.getPreco());
        resultado = verificadorDoQuarto(this.pedido.getIdQuarto()) && resultado;
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
    public Boolean verificadorDoQuarto(Integer id ){
        List<Pedido> lista = pedidoRepository.findByIdQuarto(id);
        if(lista.isEmpty()) {
            erros.add("O quarto não está na lista");
            return false;
        }
        if (!idQuartoAtivo(id)){
            erros.add("O quarto não está na lista");
            return false;
        }
        else {
            return true;
        }

    }
    public Boolean idQuartoAtivo(Integer id){
        Boolean quartoexiste = quartoRepository.findById(id).get().getAtivo();

        return quartoexiste;
    }


}
