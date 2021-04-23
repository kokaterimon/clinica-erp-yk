package com.clinica.erp.repository;

import com.clinica.erp.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
