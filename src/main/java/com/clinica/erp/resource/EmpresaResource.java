package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Empresa;
import com.clinica.erp.repository.EmpresaRepository;
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
@RequestMapping("/empresas")
public class EmpresaResource {
        @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Empresa> crear(@Validated @RequestBody Empresa empresa, HttpServletResponse response) {        
        Empresa empresaSave = empresaRepository.save(empresa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(empresaSave.getIdEmpresa()).toUri();
		
		return ResponseEntity.created(uri).body(empresaSave);
    }

    @GetMapping("/{id}")
    public Empresa mostrar(@PathVariable Integer id){
        return empresaRepository.findById(id).get();       
    }
}
