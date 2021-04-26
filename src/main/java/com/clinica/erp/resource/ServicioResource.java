package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Servicio;
import com.clinica.erp.repository.ServicioRepository;
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
@RequestMapping("/servicios")
public class ServicioResource {
        @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping
    public List<Servicio> listar() {
        return servicioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Servicio> crear(@Validated @RequestBody Servicio servicio, HttpServletResponse response) {        
        Servicio servicioSave = servicioRepository.save(servicio);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(servicioSave.getIdServicio()).toUri();
		
		return ResponseEntity.created(uri).body(servicioSave);
    }

    @GetMapping("/{id}")
    public Servicio mostrar(@PathVariable Integer id){
        return servicioRepository.findById(id).get();       
    }
}
