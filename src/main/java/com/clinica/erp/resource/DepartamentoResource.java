package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Departamento;
import com.clinica.erp.repository.DepartamentoRepository;

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
@RequestMapping("/departamentos")
public class DepartamentoResource {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping
    public List<Departamento> listar() {
        return departamentoRepository.findAll();
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Departamento> crear(@Validated @RequestBody Departamento departamento, HttpServletResponse response) {        
        Departamento departamentoSave = departamentoRepository.save(departamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(departamentoSave.getIdDepartamento()).toUri();
        //response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(departamentoSave);
    }

    @GetMapping("/{id}")
    public Departamento mostrar(@PathVariable Integer id){
        // return departamentoRepository.getOne(idDepartamento);

       // Optional<Departamento> optinalEntity =  departamentoRepository.findById(id);
       // Departamento roomEntity = optionalEntity.get();
        return departamentoRepository.findById(id).get();       
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> actualizar(@PathVariable Integer id, @Validated @RequestBody Departamento departamento){
        Departamento departamentoSave;        
        try{
            departamentoSave = departamentoRepository.findById(id).get();
            BeanUtils.copyProperties(departamento, departamentoSave,"idDepartamento");
            departamentoRepository.save(departamentoSave);
            
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(departamentoSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        departamentoRepository.deleteById(id);
    }

}