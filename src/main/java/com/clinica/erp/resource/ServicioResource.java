package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Servicio;
import com.clinica.erp.repository.ServicioRepository;

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

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> actualizar(@PathVariable Integer id, @Validated @RequestBody Servicio servicio){
        Servicio servicioSave;        
        try{
            servicioSave = servicioRepository.findById(id).get();
            BeanUtils.copyProperties(servicio, servicioSave,"idServicio");
            servicioRepository.save(servicioSave);
            
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(servicioSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        servicioRepository.deleteById(id);
    }
}
