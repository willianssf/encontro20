package com.vespertino.hotelvesp.repositories;

import com.vespertino.hotelvesp.entities.Andar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AndarRepository extends JpaRepository<Andar,Integer> {
    List<Andar> findByAtivo(Boolean ativo);

}
