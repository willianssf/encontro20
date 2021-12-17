package com.vespertino.hotelvesp.controller;

import com.vespertino.hotelvesp.Mensagem;
import com.vespertino.hotelvesp.entities.Andar;
import com.vespertino.hotelvesp.repositories.AndarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("andar")
public class AndarController {
    @Autowired
    private AndarRepository andarRepository;
    @GetMapping
    public List<Andar> listar(){
        List<Andar> lista = andarRepository.findByAtivo(true);
        return lista;
    }
    @GetMapping("/{id}")
    public Andar buscar(@PathVariable int id){
        Andar andar = andarRepository.findById(id).get();
        return andar;
    }
    @PostMapping
    public Mensagem incluirAndar(@RequestBody Andar andar){
        andar.setId(0);
        andarRepository.save(andar);
        andarRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("ok");
        return msg;


    }
    @PutMapping
    public Mensagem alterar (@RequestBody Andar andar){
        andarRepository.save(andar);
        andarRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("ok");
        return msg;

    }
    @DeleteMapping
    public Mensagem Deletar(@RequestBody Andar andar){
        andar.setAtivo(false);
        andarRepository.save(andar);
        andarRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("deletado");
        return msg;





    }

}
