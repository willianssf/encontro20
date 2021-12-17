package com.vespertino.hotelvesp.repositories;

import com.vespertino.hotelvesp.entities.Funcionario;
import com.vespertino.hotelvesp.entities.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    List<Funcionario> findByAtivo(Boolean ativo);
}
