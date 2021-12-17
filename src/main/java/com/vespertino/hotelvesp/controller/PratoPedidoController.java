package com.vespertino.hotelvesp.controller;

import com.vespertino.hotelvesp.Mensagem;
import com.vespertino.hotelvesp.entities.Pedido;
import com.vespertino.hotelvesp.entities.Prato;
import com.vespertino.hotelvesp.entities.PratoPedido;
import com.vespertino.hotelvesp.repositories.PedidoRepository;
import com.vespertino.hotelvesp.repositories.PratoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pratopedido")
public class PratoPedidoController {


    @Autowired
    private PratoPedidoRepository pratoPedidoRepository;

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
        pedido.setId(0);
        pratoPedidoRepository.saveAndFlush(pedido);
        ;
        Mensagem msg = new Mensagem();
        msg.setMensagem("Incluido com sucesso");
        return msg;
    }

    @PutMapping
    public Mensagem alterar (@RequestBody PratoPedido pedido) {
        pratoPedidoRepository.saveAndFlush(pedido);

        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado com sucesso");
        return msg;
    }

}
