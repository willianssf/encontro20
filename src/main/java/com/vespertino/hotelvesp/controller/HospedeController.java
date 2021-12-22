package com.vespertino.hotelvesp.controller;


import com.vespertino.hotelvesp.Mensagem;
import com.vespertino.hotelvesp.business.FuncionarioBiz;
import com.vespertino.hotelvesp.business.HospedeBiz;
import com.vespertino.hotelvesp.entities.Hospede;
import com.vespertino.hotelvesp.repositories.HospedeRepository;
import com.vespertino.hotelvesp.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hospede")
public class HospedeController {

    @Autowired
    private HospedeRepository hospedeRepository;
    @Autowired
    private QuartoRepository quartoRepository;

    @GetMapping
    public List<Hospede> lista(){
        List<Hospede> lista = hospedeRepository.findByativo(true);
        return lista;

    }
    @GetMapping("/{id}")
    public Hospede buscar(@PathVariable int id){
        Hospede hospede = hospedeRepository.findById(id).get();
        return hospede;

    }
    @PostMapping
    public Mensagem incluir(@RequestBody Hospede hospede){

        HospedeBiz hospedeBiz = new HospedeBiz(hospede, hospedeRepository , quartoRepository);
        Mensagem msg = new Mensagem();

        if (hospedeBiz.isValid()) {
            hospede.setId(0);
            hospedeRepository.save(hospede);
            hospedeRepository.flush();
            msg.setMensagem("ok");
        } else {
            msg.setErro( hospedeBiz.getErros() );
            msg.setMensagem("Erro");
        }
        return msg;

    }
    @PutMapping
    public Mensagem alterar (@RequestBody Hospede hospede){
        hospedeRepository.saveAndFlush(hospede);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Ok");
        return msg;
    }
    @DeleteMapping
    public Mensagem deletar (@RequestBody Hospede hospede){
        hospede.setAtivo(false);
        hospedeRepository.saveAndFlush(hospede);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado");
        return msg;
    }

}
