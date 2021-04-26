package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.TiempoProceso;
import com.clinica.erp.repository.TiempoProcesoRepository;

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
@RequestMapping("/tiempoProcesos")
public class TiempoProcesoResource {
        @Autowired
    private TiempoProcesoRepository tiempoProcesoRepository;

    @GetMapping
    public List<TiempoProceso> listar() {
        return tiempoProcesoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<TiempoProceso> crear(@Validated @RequestBody TiempoProceso tiempoProceso, HttpServletResponse response) {        
        TiempoProceso tiempoProcesoSave = tiempoProcesoRepository.save(tiempoProceso);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(tiempoProcesoSave.getIdTiempoProc()).toUri();
		
		return ResponseEntity.created(uri).body(tiempoProcesoSave);
    }

    @GetMapping("/{id}")
    public TiempoProceso mostrar(@PathVariable Integer id){
        return tiempoProcesoRepository.findById(id).get();       
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiempoProceso> actualizar(@PathVariable Integer id, @Validated @RequestBody TiempoProceso tiempoProceso){
        TiempoProceso tiempoProcesoSave;        
        try{
            tiempoProcesoSave = tiempoProcesoRepository.findById(id).get();
            BeanUtils.copyProperties(tiempoProceso, tiempoProcesoSave,"idTiempoProc");
            tiempoProcesoRepository.save(tiempoProcesoSave);
            
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tiempoProcesoSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        tiempoProcesoRepository.deleteById(id);
    }
}
