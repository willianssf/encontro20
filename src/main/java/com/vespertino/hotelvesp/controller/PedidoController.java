package com.vespertino.hotelvesp.controller;

import com.vespertino.hotelvesp.Mensagem;
import com.vespertino.hotelvesp.entities.Pedido;
import com.vespertino.hotelvesp.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listar () {
        List<Pedido> lista = pedidoRepository.findByAtivo(true);
        return lista;
    }
    @GetMapping("/{id}")
    public Pedido buscar (@PathVariable int id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        return pedido;
   }

    @GetMapping("/quarto/{id}")
    public List<Pedido> x (@PathVariable int id) {
        List<Pedido> pedido = pedidoRepository.findAll();

        return pedido.stream().filter(x->x.getIdQuarto() == id).collect(Collectors.toList());

    }

    @PostMapping
    public Mensagem incluir (@RequestBody Pedido pedido) {
        pedido.setId(0);
        pedidoRepository.saveAndFlush(pedido);

        Mensagem msg = new Mensagem();
        msg.setMensagem("Incluido com sucesso");
        return msg;
    }

    @PutMapping
    public Mensagem alterar (@RequestBody Pedido pedido) {
        pedidoRepository.saveAndFlush(pedido);

        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado com sucesso");
        return msg;
    }
}
