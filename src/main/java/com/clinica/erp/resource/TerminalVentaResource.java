package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.TerminalVenta;
import com.clinica.erp.repository.TerminalVentaRepository;
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
@RequestMapping("/terminalVentas")
public class TerminalVentaResource {
        @Autowired
    private TerminalVentaRepository terminalVentaRepository;

    @GetMapping
    public List<TerminalVenta> listar() {
        return terminalVentaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<TerminalVenta> crear(@Validated @RequestBody TerminalVenta terminalVenta, HttpServletResponse response) {        
        TerminalVenta terminalVentaSave = terminalVentaRepository.save(terminalVenta);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(terminalVentaSave.getIdTerminal()).toUri();
		
		return ResponseEntity.created(uri).body(terminalVentaSave);
    }

    @GetMapping("/{id}")
    public TerminalVenta mostrar(@PathVariable Integer id){
        return terminalVentaRepository.findById(id).get();       
    }
}
