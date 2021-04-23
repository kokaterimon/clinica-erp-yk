package com.clinica.erp.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;

import com.clinica.erp.model.Usuario;
import com.clinica.erp.repository.UsuarioRepository;
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
@RequestMapping("/usuarios")
public class UsuarioResource {
        @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@Validated @RequestBody Usuario usuario, HttpServletResponse response) {        
        Usuario usuarioSave = usuarioRepository.save(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(usuarioSave.getIdUsuario()).toUri();
		
		return ResponseEntity.created(uri).body(usuarioSave);
    }

    @GetMapping("/{id}")
    public Usuario mostrar(@PathVariable Integer id){
        return usuarioRepository.findById(id).get();       
    }
}
