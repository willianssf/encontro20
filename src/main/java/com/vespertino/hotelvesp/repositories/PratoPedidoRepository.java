package com.vespertino.hotelvesp.repositories;

import com.vespertino.hotelvesp.entities.Pedido;
import com.vespertino.hotelvesp.entities.PratoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PratoPedidoRepository extends JpaRepository<PratoPedido,Integer> {


}