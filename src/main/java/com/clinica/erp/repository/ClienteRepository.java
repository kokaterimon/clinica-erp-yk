package com.clinica.erp.repository;

import com.clinica.erp.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
