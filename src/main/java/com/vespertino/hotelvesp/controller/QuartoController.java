package com.vespertino.hotelvesp.controller;

import com.vespertino.hotelvesp.Mensagem;
import com.vespertino.hotelvesp.entities.Quarto;
import com.vespertino.hotelvesp.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quarto")
public class QuartoController {
    @Autowired
    private QuartoRepository quartoRepository;

    @GetMapping
    public List listar () {
        List<Quarto> lista = quartoRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Quarto buscar (@PathVariable int id) {
        Quarto quarto = quartoRepository.findById(id).get();
        return quarto;
    }

    @PostMapping
    public Mensagem incluir (@RequestBody Quarto quarto) {
        quarto.setId(0);
        quartoRepository.save(quarto);
        quartoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Incluido com sucesso");
        return msg;
    }
}
