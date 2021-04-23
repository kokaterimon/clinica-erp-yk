package com.clinica.erp.repository;

import com.clinica.erp.model.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    
}
