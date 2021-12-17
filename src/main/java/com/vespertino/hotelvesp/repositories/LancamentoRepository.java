package com.vespertino.hotelvesp.repositories;

import com.vespertino.hotelvesp.entities.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
    List<Lancamento> findByAtivo(Boolean ativo);
}
