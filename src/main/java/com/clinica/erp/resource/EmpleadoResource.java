package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Empleado;
import com.clinica.erp.repository.EmpleadoRepository;

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
@RequestMapping("/empleados")
public class EmpleadoResource {
        @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public List<Empleado> listar() {
        return empleadoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Empleado> crear(@Validated @RequestBody Empleado empleado, HttpServletResponse response) {        
        Empleado empleadoSave = empleadoRepository.save(empleado);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(empleadoSave.getIdEmpleado()).toUri();
		
		return ResponseEntity.created(uri).body(empleadoSave);
    }

    @GetMapping("/{id}")
    public Empleado mostrar(@PathVariable Integer id){
        return empleadoRepository.findById(id).get();       
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Integer id, @Validated @RequestBody Empleado empleado){
        Empleado empleadoSave;        
        try{
            empleadoSave = empleadoRepository.findById(id).get();
            BeanUtils.copyProperties(empleado, empleadoSave,"idEmpleado");
            empleadoRepository.save(empleadoSave);
            
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empleadoSave);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Integer id) {
        empleadoRepository.deleteById(id);
    }
}
