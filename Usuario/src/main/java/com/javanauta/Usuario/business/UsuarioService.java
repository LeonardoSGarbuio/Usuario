package com.javanauta.Usuario.business;

import com.javanauta.Usuario.business.DTO.UsuarioDTO;
import com.javanauta.Usuario.business.converter.UsuarioConverter;
import com.javanauta.Usuario.infrastructure.entity.Usuario;
import com.javanauta.Usuario.infrastructure.exceptions.ConflictException;
import com.javanauta.Usuario.infrastructure.exceptions.ResourseNotFoundException;
import com.javanauta.Usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        emailExiste(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }

    public boolean verificarEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void emailExiste(String email) {
        try {
            boolean existe = verificarEmailExistente(email);
            if (existe) {
                throw new ConflictException("Email já cadastrado");
            }
        } catch (ConflictException e){
            throw new ConflictException("Email já cadastrado ", e.getCause());
        }
    }

    public Usuario buscarUsuarioPorEmail (String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourseNotFoundException("Email não cadastrado"));
    }

    public void deletaUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }
}

