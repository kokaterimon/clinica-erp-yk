package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Distrito;
import com.clinica.erp.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/distritos")
public class DistritoResource {
        @Autowired
    private DistritoRepository distritoRepository;

    @GetMapping
    public List<Distrito> listar(@RequestParam(required=false,name="Prov_likes") Integer idProvincia) {
        if(idProvincia != null){
            return distritoRepository.findByidProvincia(idProvincia);
        }
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
    public Distrito mostrar(@PathVariable Integer id){
        return distritoRepository.findById(id).get();       
    }
}
