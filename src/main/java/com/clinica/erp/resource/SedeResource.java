package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Sede;
import com.clinica.erp.repository.SedeRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/sedes")
public class SedeResource {
        @Autowired
    private SedeRepository sedeRepository;

    @GetMapping
    public List<Sede> listar() {
        return sedeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Sede> crear(@Validated @RequestBody Sede sede, HttpServletResponse response) {        
        Sede sedeSave = sedeRepository.save(sede);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(sedeSave.getIdSede()).toUri();
		
		return ResponseEntity.created(uri).body(sedeSave);
    }

    @GetMapping("/{id}")
    public Sede mostrar(@PathVariable Integer id){
        return sedeRepository.findById(id).get();       
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sede> actualizar(@PathVariable Integer id, @Validated @RequestBody Sede sede){
        Sede sedeSave;        
        try{
            sedeSave = sedeRepository.findById(id).get();
            BeanUtils.copyProperties(sede, sedeSave,"idSede");
            sedeRepository.save(sedeSave);
            
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sedeSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        sedeRepository.deleteById(id);
    }
}
