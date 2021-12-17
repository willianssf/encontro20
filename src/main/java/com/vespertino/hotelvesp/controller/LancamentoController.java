package com.vespertino.hotelvesp.controller;

import com.vespertino.hotelvesp.Mensagem;
import com.vespertino.hotelvesp.entities.Lancamento;
import com.vespertino.hotelvesp.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lancamento")
public class LancamentoController {
    @Autowired
    private LancamentoRepository lancamentoRepository;

    @GetMapping
    public List listar () {
        List<Lancamento> listar = lancamentoRepository.findByAtivo(true);
        return listar;
    }

    @GetMapping("/{id}")
    public Lancamento buscar (@PathVariable int id) {
        Lancamento lancamento = lancamentoRepository.findById(id).get();
        return lancamento;
    }

    @PostMapping
    public Mensagem incluir (@RequestBody Lancamento lancamento) {
        lancamento.setId(0);
        lancamentoRepository.save(lancamento);
        lancamentoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Incluido com sucesso");
        return msg;
    }

    @PutMapping
    public Mensagem alterar (@RequestBody Lancamento lancamento) {
        lancamentoRepository.save(lancamento);
        lancamentoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado com sucesso");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar (@RequestBody Lancamento lancamento) {
        lancamento.setAtivo(false);
        lancamentoRepository.save(lancamento);
        lancamentoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado com sucesso");
        return msg;
    }
}
