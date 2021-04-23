package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Area;
import com.clinica.erp.repository.AreaRepository;
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
@RequestMapping("/areas")
public class AreaResource {
        @Autowired
    private AreaRepository areaRepository;

    @GetMapping
    public List<Area> listar() {
        return areaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Area> crear(@Validated @RequestBody Area area, HttpServletResponse response) {        
        Area areaSave = areaRepository.save(area);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(areaSave.getIdArea()).toUri();
		
		return ResponseEntity.created(uri).body(areaSave);
    }

    @GetMapping("/{id}")
    public Area mostrar(@PathVariable Integer id){
        return areaRepository.findById(id).get();       
    }
}
