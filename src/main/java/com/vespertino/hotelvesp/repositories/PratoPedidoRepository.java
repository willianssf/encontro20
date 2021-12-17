package com.vespertino.hotelvesp.repositories;

import com.vespertino.hotelvesp.entities.PratoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PratoPedidoRepository extends JpaRepository<PratoPedido,Integer> {
}