package com.clinica.erp.repository;

import java.util.List;

import com.clinica.erp.model.Distrito;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DistritoRepository extends JpaRepository<Distrito, Integer>{
    
    List<Distrito> findByidProvincia(Integer idProvincia);

}
