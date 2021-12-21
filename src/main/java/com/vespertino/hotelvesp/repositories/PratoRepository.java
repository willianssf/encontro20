package com.vespertino.hotelvesp.repositories;

import com.vespertino.hotelvesp.entities.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Integer> {

    List<Prato> findByAtivo(Boolean ativo);
    List<Prato> findByNome(String nome);
}
