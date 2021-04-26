package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.DetalleVenta;
import com.clinica.erp.repository.DetalleVentaRepository;
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
@RequestMapping("/detalleVentas")
public class DetalleVentaResource {
        @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @GetMapping
    public List<DetalleVenta> listar() {
        return detalleVentaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> crear(@Validated @RequestBody DetalleVenta detalleVenta, HttpServletResponse response) {        
        DetalleVenta detalleVentaSave = detalleVentaRepository.save(detalleVenta);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(detalleVentaSave.getId()).toUri();
		
		return ResponseEntity.created(uri).body(detalleVentaSave);
    }

    @GetMapping("/{id}")
    public DetalleVenta mostrar(@PathVariable Integer id){
        return detalleVentaRepository.findById(id).get();       
    }
}
