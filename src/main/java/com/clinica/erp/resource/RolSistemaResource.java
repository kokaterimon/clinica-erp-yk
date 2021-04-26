package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.RolSistema;
import com.clinica.erp.repository.RolSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/rolSistema")
public class RolSistemaResource {
        @Autowired
    private RolSistemaRepository rolSistemaRepository;

    @GetMapping
    public List<RolSistema> listar() {
        return rolSistemaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<RolSistema> crear(@Validated @RequestBody RolSistema rolSistema, HttpServletResponse response) {        
        RolSistema rolSistemaSave = rolSistemaRepository.save(rolSistema);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(rolSistemaSave.getIdRolSistema()).toUri();
		
		return ResponseEntity.created(uri).body(rolSistemaSave);
    }

    @GetMapping("/{id}")
    public RolSistema mostrar(@PathVariable Integer id){
        return rolSistemaRepository.findById(id).get();       
    }
}
