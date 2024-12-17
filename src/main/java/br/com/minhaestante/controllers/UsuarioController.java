package br.com.minhaestante.controllers;

import br.com.minhaestante.models.UsuarioModel;
import br.com.minhaestante.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/minhaestante/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/inicio")
    public String helloWorld() {
        return "Hello world";
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioModel usuarioModel) {
        UsuarioModel novoUsuario = usuarioService.cadastrar(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

}
