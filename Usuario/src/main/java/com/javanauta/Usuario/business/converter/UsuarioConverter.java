package com.javanauta.Usuario.business.converter;

import com.javanauta.Usuario.business.DTO.EnderecoDTO;
import com.javanauta.Usuario.business.DTO.TelefoneDTO;
import com.javanauta.Usuario.business.DTO.UsuarioDTO;
import com.javanauta.Usuario.infrastructure.entity.Enderecos;
import com.javanauta.Usuario.infrastructure.entity.Telefones;
import com.javanauta.Usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefones(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Enderecos> paraListaEndereco(List<EnderecoDTO> enderecoDTOS) {
        return enderecoDTOS.stream().map(this::paraEndereco).toList();
        // equivalente a:
        // List<Enderecos> enderecos = new ArrayList<>();
        // for (EnderecoDTO enderecoDTO : enderecoDTOS) {
        //    enderecos.add(paraEndereco(enderecoDTO));
        // }
        // return enderecos;
    }

    public Enderecos paraEndereco(EnderecoDTO enderecoDTO) {
        return Enderecos.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<Telefones> paraListaTelefones(List<TelefoneDTO> telefoneDTOS) {
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
        // equivalente a:
        // List<Telefones> telefones = new ArrayList<>();
        // for (TelefoneDTO telefoneDTO : telefoneDTOS) {
        //    telefones.add(paraTelefone(telefoneDTO));
        // }
        // return telefones;
    }

    public Telefones paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefones.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO (Usuario usuario) {
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefones(paraListaTelefonesDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Enderecos> enderecos) {
        return enderecos.stream().map(this::paraEnderecoDTO).toList();
    }

    public EnderecoDTO paraEnderecoDTO(Enderecos enderecos) {
        return EnderecoDTO.builder()
                .rua(enderecos.getRua())
                .numero(enderecos.getNumero())
                .cidade(enderecos.getCidade())
                .complemento(enderecos.getComplemento())
                .cep(enderecos.getCep())
                .estado(enderecos.getEstado())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefonesDTO(List<Telefones> telefones) {
        return telefones.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefones telefones) {
        return TelefoneDTO.builder()
                .numero(telefones.getNumero())
                .ddd(telefones.getDdd())
                .build();
    }

}
