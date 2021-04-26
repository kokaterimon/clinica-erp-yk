package com.clinica.erp.repository;

import com.clinica.erp.model.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
    
}
