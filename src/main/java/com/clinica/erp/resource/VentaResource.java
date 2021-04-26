package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Venta;
import com.clinica.erp.repository.VentaRepository;
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
@RequestMapping("/ventas")
public class VentaResource {
        @Autowired
    private VentaRepository ventaRepository;

    @GetMapping
    public List<Venta> listar() {
        return ventaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Venta> crear(@Validated @RequestBody Venta venta, HttpServletResponse response) {        
        Venta ventaSave = ventaRepository.save(venta);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(ventaSave.getIdVenta()).toUri();
		
		return ResponseEntity.created(uri).body(ventaSave);
    }

    @GetMapping("/{id}")
    public Venta mostrar(@PathVariable Integer id){
        return ventaRepository.findById(id).get();       
    }
}
