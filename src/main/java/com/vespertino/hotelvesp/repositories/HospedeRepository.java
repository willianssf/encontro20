package com.vespertino.hotelvesp.repositories;

import com.vespertino.hotelvesp.entities.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospedeRepository extends JpaRepository<Hospede, Integer> {

    List<Hospede> findByativo(Boolean ativo);
}
