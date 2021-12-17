package com.vespertino.hotelvesp.controller;

import com.vespertino.hotelvesp.Mensagem;
import com.vespertino.hotelvesp.entities.Pedido;
import com.vespertino.hotelvesp.entities.Prato;
import com.vespertino.hotelvesp.repositories.PedidoRepository;
import com.vespertino.hotelvesp.repositories.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prato")
public class PratoController {

    @Autowired
    private PratoRepository pratoRepository;

    @GetMapping
    public List<Prato> listar () {
        List<Prato> lista = pratoRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Prato buscar (@PathVariable int id) {
        Prato prato = pratoRepository.findById(id).get();
        return prato;
    }

    @PostMapping
    public Mensagem incluir (@RequestBody Prato prato) {
        prato.setId(0);
        pratoRepository.saveAndFlush(prato);
        ;
        Mensagem msg = new Mensagem();
        msg.setMensagem("Incluido com sucesso");
        return msg;
    }

    @PutMapping
    public Mensagem alterar (@RequestBody Prato prato) {
        pratoRepository.saveAndFlush(prato);

        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado com sucesso");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar (@RequestBody Prato prato) {
        prato.setAtivo(false);
        pratoRepository.saveAndFlush(prato);

        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado com sucesso");
        return msg;
    }
}
