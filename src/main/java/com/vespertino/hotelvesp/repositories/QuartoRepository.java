package com.vespertino.hotelvesp.repositories;

import com.vespertino.hotelvesp.entities.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
    List<Quarto> findByAtivo(Boolean ativo);
}
