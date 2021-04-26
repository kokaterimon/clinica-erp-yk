package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.TipoServicio;
import com.clinica.erp.repository.TipoServicioRepository;

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
@RequestMapping("/tipoServicios")
public class TipoServicioResource {
        @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @GetMapping
    public List<TipoServicio> listar() {
        return tipoServicioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<TipoServicio> crear(@Validated @RequestBody TipoServicio tipoServicio, HttpServletResponse response) {        
        TipoServicio tipoServicioSave = tipoServicioRepository.save(tipoServicio);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(tipoServicioSave.getIdTipoServicio()).toUri();
		
		return ResponseEntity.created(uri).body(tipoServicioSave);
    }

    @GetMapping("/{id}")
    public TipoServicio mostrar(@PathVariable Integer id){
        return tipoServicioRepository.findById(id).get();       
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoServicio> actualizar(@PathVariable Integer id, @Validated @RequestBody TipoServicio tipoServicio){
        TipoServicio tipoServicioSave;        
        try{
            tipoServicioSave = tipoServicioRepository.findById(id).get();
            BeanUtils.copyProperties(tipoServicio, tipoServicioSave,"idTipoServicio");
            tipoServicioRepository.save(tipoServicioSave);
            
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tipoServicioSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        tipoServicioRepository.deleteById(id);
    }
}
