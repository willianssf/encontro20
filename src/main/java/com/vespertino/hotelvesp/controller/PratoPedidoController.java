package com.vespertino.hotelvesp.controller;

import com.vespertino.hotelvesp.Mensagem;
import com.vespertino.hotelvesp.business.FuncionarioBiz;
import com.vespertino.hotelvesp.business.PratoPedidoBiz;
import com.vespertino.hotelvesp.entities.Pedido;
import com.vespertino.hotelvesp.entities.Prato;
import com.vespertino.hotelvesp.entities.PratoPedido;
import com.vespertino.hotelvesp.repositories.PedidoRepository;
import com.vespertino.hotelvesp.repositories.PratoPedidoRepository;
import com.vespertino.hotelvesp.repositories.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pratopedido")
public class PratoPedidoController {


    @Autowired
    private PratoPedidoRepository pratoPedidoRepository;
    private PratoRepository pratoRepository;
    private PedidoRepository pedidoRepository;


    @GetMapping
    public List<PratoPedido> listar () {
        List<PratoPedido> lista = pratoPedidoRepository.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public PratoPedido buscar (@PathVariable int id) {
        PratoPedido pedido = pratoPedidoRepository.findById(id).get();
        return pedido;
    }

    @PostMapping
    public Mensagem incluir (@RequestBody PratoPedido pedido) {
        PratoPedidoBiz pratoPedidoBiz  = new PratoPedidoBiz(pedido, pratoPedidoRepository, pratoRepository,
                pedidoRepository);
        Mensagem msg = new Mensagem();

        if (pratoPedidoBiz.isValid()) {
            pedido.setId(0);
            pratoPedidoRepository.saveAndFlush(pedido);
            msg.setMensagem("ok");

        } else {
            msg.setMensagem("Erro");
            msg.setErro( pratoPedidoBiz.getErros() );
        }
        return msg;
    }

    @PutMapping
    public Mensagem alterar (@RequestBody PratoPedido pedido) {
        PratoPedidoBiz pratoPedidoBiz  = new PratoPedidoBiz(pedido, pratoPedidoRepository,pratoRepository,
                pedidoRepository);
        Mensagem msg = new Mensagem();

        if (pratoPedidoBiz.isValid()) {
            pratoPedidoRepository.saveAndFlush(pedido);
            msg.setMensagem("Alterado com sucesso");
        } else {
            msg.setMensagem("Erro");
            msg.setErro( pratoPedidoBiz.getErros() );
        }

        return msg;
    }

}
