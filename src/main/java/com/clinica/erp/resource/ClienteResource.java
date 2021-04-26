package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Cliente;
import com.clinica.erp.repository.ClienteRepository;
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
@RequestMapping("/clientes")
public class ClienteResource {
        @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@Validated @RequestBody Cliente cliente, HttpServletResponse response) {        
        Cliente clienteSave = clienteRepository.save(cliente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(clienteSave.getIdCliente()).toUri();
		
		return ResponseEntity.created(uri).body(clienteSave);
    }

    @GetMapping("/{id}")
    public Cliente mostrar(@PathVariable Integer id){
        return clienteRepository.findById(id).get();       
    }
}
