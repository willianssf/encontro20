package com.vespertino.hotelvesp.repositories;


import com.vespertino.hotelvesp.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
    List<Pedido> findByAtivo(Boolean ativo);
    List<Pedido> findByIdQuarto(Integer idQuarto);

}
