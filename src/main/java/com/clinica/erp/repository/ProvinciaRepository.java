package com.clinica.erp.repository;

import java.util.List;

import com.clinica.erp.model.Provincia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

    List<Provincia> findByidDepartamento(Integer idDepartamento);
}
