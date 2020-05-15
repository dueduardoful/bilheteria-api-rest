package com.apirest.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.apirest.entidades.CasaDeShow;

@Repository
public interface CasaDeShowRepository extends JpaRepository<CasaDeShow, Long> {

}
