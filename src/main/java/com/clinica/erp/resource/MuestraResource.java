package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Muestra;
import com.clinica.erp.repository.MuestraRepository;
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
@RequestMapping("/muestras")
public class MuestraResource {
        @Autowired
    private MuestraRepository muestraRepository;

    @GetMapping
    public List<Muestra> listar() {
        return muestraRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Muestra> crear(@Validated @RequestBody Muestra muestra, HttpServletResponse response) {        
        Muestra muestraSave = muestraRepository.save(muestra);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(muestraSave.getIdMuestra()).toUri();
		
		return ResponseEntity.created(uri).body(muestraSave);
    }

    @GetMapping("/{id}")
    public Muestra mostrar(@PathVariable Integer id){
        return muestraRepository.findById(id).get();       
    }
}
