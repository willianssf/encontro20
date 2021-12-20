package com.vespertino.hotelvesp.controller;

import com.vespertino.hotelvesp.Mensagem;
import com.vespertino.hotelvesp.entities.Funcionario;
import com.vespertino.hotelvesp.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @GetMapping
    public List<Funcionario> listar(){
        List<Funcionario> lista = funcionarioRepository.findByAtivo(true);
        return lista;
    }
    @GetMapping("/{id}")
    public Funcionario buscar(@PathVariable int id){
        Funcionario funcionario = funcionarioRepository.findById(id).get();
        return funcionario;
    }
    @PostMapping
    public Mensagem incluirFunc(@RequestBody Funcionario funcionario){
        funcionario.setId(0);
        funcionarioRepository.save(funcionario);
        funcionarioRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("ok");
        return msg;


    }
    @PutMapping
    public Mensagem alterar (@RequestBody Funcionario funcionario){
        funcionarioRepository.save(funcionario);
        funcionarioRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("ok");
        return msg;

    }
    @DeleteMapping
    public Mensagem Deletar(@RequestBody Funcionario funcionario){
        funcionario.setAtivo(false);
        funcionarioRepository.save(funcionario);
        funcionarioRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("deletado");
        return msg;

    }

}

