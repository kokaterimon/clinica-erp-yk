package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.EmpInstitucion;
import com.clinica.erp.repository.EmpInstitucionRepository;
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
@RequestMapping("/empInstitucion")
public class EmpInstitucionResource {
        @Autowired
    private EmpInstitucionRepository empInstitucionRepository;

    @GetMapping
    public List<EmpInstitucion> listar() {
        return empInstitucionRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<EmpInstitucion> crear(@Validated @RequestBody EmpInstitucion empInstitucion, HttpServletResponse response) {        
        EmpInstitucion empInstitucionSave = empInstitucionRepository.save(empInstitucion);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(empInstitucionSave.getId()).toUri();
		
		return ResponseEntity.created(uri).body(empInstitucionSave);
    }

    @GetMapping("/{id}")
    public EmpInstitucion mostrar(@PathVariable Integer id){
        return empInstitucionRepository.findById(id).get();       
    }
}
