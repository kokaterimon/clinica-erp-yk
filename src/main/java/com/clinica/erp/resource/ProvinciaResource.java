package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Provincia;
import com.clinica.erp.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/provincias")
public class ProvinciaResource {
    @Autowired
    private ProvinciaRepository provinciaRepository;

    
    @GetMapping
    public List<Provincia> mostrarPorDepartamento(@RequestParam(required=false,name="Dep_likes") Integer idDepartamento) {
        if(idDepartamento != null){
            return provinciaRepository.findByidDepartamento(idDepartamento);
        }
        return provinciaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Provincia> crear(@Validated @RequestBody Provincia provincia, HttpServletResponse response) {
        Provincia provinciaSave = provinciaRepository.save(provincia);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(provinciaSave.getIdProvincia()).toUri();

        return ResponseEntity.created(uri).body(provinciaSave);
    }

    @GetMapping("/{id}")
    public Provincia mostrar(@PathVariable Integer id) {
        return provinciaRepository.findById(id).get();
    }
}
