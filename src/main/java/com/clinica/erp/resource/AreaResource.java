package com.clinica.erp.resource;

import java.util.List;

import java.net.URI;

import com.clinica.erp.model.Area;
import com.clinica.erp.repository.AreaRepository;

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
@RequestMapping("/areas")
public class AreaResource {

    @Autowired
    private AreaRepository areaRepository;

    @GetMapping
    public List<Area> listar() {
        return areaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Area> crear(@Validated @RequestBody Area area) {
        Area areaSave = areaRepository.save(area);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(areaSave.getIdArea())
                .toUri();

        return ResponseEntity.created(uri).body(areaSave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> mostrar(@PathVariable Integer id) {
        Area area;
        try {
            area = areaRepository.findById(id).get();
        } catch (Exception e) {
            area = null;
        }

        return area != null ? ResponseEntity.ok(area) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> actualizar(@PathVariable Integer id, @Validated @RequestBody Area area){
        Area areaSave;        
        try{
            areaSave = areaRepository.findById(id).get();
            BeanUtils.copyProperties(area, areaSave,"idArea");
            areaRepository.save(areaSave);
            
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(areaSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        areaRepository.deleteById(id);
    }

}
