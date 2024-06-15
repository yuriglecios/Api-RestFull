package com.api.controller;

import com.api.model.Usuario;
import com.api.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> teste(@PathVariable Integer id) {
        var usuario = usuarioRepository.findById(id);
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        var validaUsuaruio = usuarioRepository.findById(usuario.getId());
        if (validaUsuaruio != null) {
            usuarioRepository.save(usuario);
        }
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Integer id) {
        var usuario = usuarioRepository.findById(id);
        if (usuario != null) {
            usuarioRepository.deleteById(id);
        }
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

}
