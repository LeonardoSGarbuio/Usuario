package com.javanauta.Usuario.business;

import com.javanauta.Usuario.business.DTO.UsuarioDTO;
import com.javanauta.Usuario.business.converter.UsuarioConverter;
import com.javanauta.Usuario.infrastructure.entity.Usuario;
import com.javanauta.Usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }

}
