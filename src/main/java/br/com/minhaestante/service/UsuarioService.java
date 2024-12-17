package br.com.minhaestante.service;

import br.com.minhaestante.models.UsuarioModel;
import br.com.minhaestante.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel cadastrar(UsuarioModel usuario) {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException(
                    "O e-mail informado já está em uso."
            );
        }

        UsuarioModel usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioSalvo;
    }

}
