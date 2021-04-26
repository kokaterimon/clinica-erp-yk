package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Institucion;
import com.clinica.erp.repository.InstitucionRepository;

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
@RequestMapping("/instituciones")
public class InstitucionResource {
        @Autowired
    private InstitucionRepository institucionRepository;

    @GetMapping
    public List<Institucion> listar() {
        return institucionRepository.findAll();

    }

    @PostMapping
    public ResponseEntity<Institucion> crear(@Validated @RequestBody Institucion institucion, HttpServletResponse response) {        
        Institucion institucionSave = institucionRepository.save(institucion);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(institucionSave.getIdInstitucion()).toUri();
		
		return ResponseEntity.created(uri).body(institucionSave);
    }

    @GetMapping("/{id}")
    public Institucion mostrar(@PathVariable Integer id){
        return institucionRepository.findById(id).get();       
    }

    @GetMapping("/?Dep_like={id}")
    public Institucion mostrarProvincias(@PathVariable Integer id){
        return institucionRepository.findById(id).get();       
    }

    @PutMapping("/{id}")
    public ResponseEntity<Institucion> actualizar(@PathVariable Integer id, @Validated @RequestBody Institucion institucion){
        Institucion institucionSave;        
        try{
            institucionSave = institucionRepository.findById(id).get();
            BeanUtils.copyProperties(institucion, institucionSave,"idInstitucion");
            institucionRepository.save(institucionSave);
            
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(institucionSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        institucionRepository.deleteById(id);
    }
}
