package com.vespertino.hotelvesp.repositories;

import com.vespertino.hotelvesp.entities.Funcionario;
import com.vespertino.hotelvesp.entities.PratoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoPedidoRepository extends JpaRepository<PratoPedido,Integer> {
    List<PratoPedido> findByIdPrato(Integer id );
    List<PratoPedido> findByIdPedido(Integer id );
}