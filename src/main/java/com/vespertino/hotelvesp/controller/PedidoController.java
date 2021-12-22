package com.vespertino.hotelvesp.controller;

import com.vespertino.hotelvesp.Mensagem;
import com.vespertino.hotelvesp.business.FuncionarioBiz;
import com.vespertino.hotelvesp.business.PedidoBiz;
import com.vespertino.hotelvesp.entities.Pedido;
import com.vespertino.hotelvesp.entities.Quarto;
import com.vespertino.hotelvesp.repositories.PedidoRepository;
import com.vespertino.hotelvesp.repositories.QuartoRepository;
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
    private QuartoRepository quartoRepository;

    @GetMapping
    public List<Pedido> listar () {
        List<Pedido> lista = pedidoRepository.findByAtivo(true);
        List<Quarto> listaQ = quartoRepository.findByAtivo(true);
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

        return pedidoRepository.findByIdQuarto(id);
    }

    @PostMapping
    public Mensagem incluir (@RequestBody Pedido pedido) {
        PedidoBiz pedidoBiz = new PedidoBiz(pedido, pedidoRepository, quartoRepository);
        Mensagem msg = new Mensagem();

        if (pedidoBiz.isValid()) {
            pedido.setId(0);
            pedidoRepository.saveAndFlush(pedido);
            msg.setMensagem("Incluido com sucesso");
        }
        else{
            msg.setErro(pedidoBiz.getErros());
            msg.setMensagem("erro");
        }
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
