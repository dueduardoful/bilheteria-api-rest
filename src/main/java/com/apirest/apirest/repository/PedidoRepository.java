package com.apirest.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.apirest.entidades.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
