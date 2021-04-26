package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.EstadoServicio;
import com.clinica.erp.repository.EstadoServicioRepository;

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
@RequestMapping("/estadoServicios")
public class EstadoServicioResource {
        @Autowired
    private EstadoServicioRepository estadoServicioRepository;

    @GetMapping
    public List<EstadoServicio> listar() {
        return estadoServicioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<EstadoServicio> crear(@Validated @RequestBody EstadoServicio estadoServicio, HttpServletResponse response) {        
        EstadoServicio estadoServicioSave = estadoServicioRepository.save(estadoServicio);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(estadoServicioSave.getIdEstadoServ()).toUri();
		
		return ResponseEntity.created(uri).body(estadoServicioSave);
    }

    @GetMapping("/{id}")
    public EstadoServicio mostrar(@PathVariable Integer id){
        return estadoServicioRepository.findById(id).get();       
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoServicio> actualizar(@PathVariable Integer id, @Validated @RequestBody EstadoServicio estadoServicio){
        EstadoServicio estadoServicioSave;        
        try{
            estadoServicioSave = estadoServicioRepository.findById(id).get();
            BeanUtils.copyProperties(estadoServicio, estadoServicioSave,"idEstadoServ");
            estadoServicioRepository.save(estadoServicioSave);
            
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estadoServicioSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        estadoServicioRepository.deleteById(id);
    }
}
