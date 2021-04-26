package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Horario;
import com.clinica.erp.repository.HorarioRepository;
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
@RequestMapping("/horarios")
public class HorarioResource {
        @Autowired
    private HorarioRepository horarioRepository;

    @GetMapping
    public List<Horario> listar() {
        return horarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Horario> crear(@Validated @RequestBody Horario horario, HttpServletResponse response) {        
        Horario horarioSave = horarioRepository.save(horario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(horarioSave.getIdHorario()).toUri();
		
		return ResponseEntity.created(uri).body(horarioSave);
    }

    @GetMapping("/{id}")
    public Horario mostrar(@PathVariable Integer id){
        return horarioRepository.findById(id).get();       
    }
}
