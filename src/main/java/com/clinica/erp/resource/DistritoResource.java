package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Distrito;
import com.clinica.erp.repository.DistritoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/distritos")
public class DistritoResource {
        @Autowired
    private DistritoRepository distritoRepository;

    @GetMapping
    public List<Distrito> listar(@RequestParam(required=false,name="Prov_likes") Integer idProvincia) {        
        return distritoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Distrito> crear(@Validated @RequestBody Distrito distrito, HttpServletResponse response) {        
        Distrito distritoSave = distritoRepository.save(distrito);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(distritoSave.getIdDistrito()).toUri();
		
		return ResponseEntity.created(uri).body(distritoSave);
    }

    @GetMapping("/{id}")
    public List<Distrito> mostrar(@PathVariable Integer id){
       // return distritoRepository.findById(id).get();     
        return distritoRepository.findByidProvincia(id);    
    }

    @PutMapping("/{id}")
    public ResponseEntity<Distrito> actualizar(@PathVariable Integer id, @Validated @RequestBody Distrito distrito){
        Distrito distritoSave;        
        try{
            distritoSave = distritoRepository.findById(id).get();
            BeanUtils.copyProperties(distrito, distritoSave,"idDistrito");
            distritoRepository.save(distritoSave);
            
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(distritoSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        distritoRepository.deleteById(id);
    }
}
