package hkeller.escolacaesguia.user.mapper;

import hkeller.escolacaesguia.tutor.dtos.CadastroTutorDto;
import hkeller.escolacaesguia.user.dtos.UsuarioDto;
import hkeller.escolacaesguia.user.models.User;

public class UsuarioMapper {
    public static UsuarioDto mapToUsuarioDto(User user) {
        UsuarioDto usuarioDto = UsuarioDto.builder()
            .id(user.getId())
            .nome(user.getNome())
            .cpf(user.getCpf())
            .email(user.getEmail())
            .telefoneCelular(user.getTelefoneCelular())
            .telefoneFixo(user.getTelefoneFixo())
            .password(user.getPassword())
            .dataNascimento(user.getDataNascimento())
            // .ativo(user.isAtivo())
            .build();

        return usuarioDto;
    }

    public static User mapToUsuario(CadastroTutorDto cadastroTutorDto) {
        User usuario = User.builder()
            .nome(cadastroTutorDto.getNome())
            .email(cadastroTutorDto.getEmail())
            .cpf(cadastroTutorDto.getCpf())
            .password(cadastroTutorDto.getPassword())
            .dataNascimento(cadastroTutorDto.getDataNascimento())
            .telefoneCelular(cadastroTutorDto.getTelefoneCelular())
            .telefoneFixo(cadastroTutorDto.getTelefoneFixo())
            .build();

        return usuario;
    }

    public static User mapToUsuario(UsuarioDto usuarioDto) {
        User usuario = User.builder()
            .id(usuarioDto.getId())
            .nome(usuarioDto.getNome())
            .email(usuarioDto.getEmail())
            .cpf(usuarioDto.getCpf())
            .password(usuarioDto.getPassword())
            .dataNascimento(usuarioDto.getDataNascimento())
            .telefoneCelular(usuarioDto.getTelefoneCelular())
            .telefoneFixo(usuarioDto.getTelefoneFixo())
            // .ativo(usuarioDto.isAtivo())
            .password(usuarioDto.getPassword())
            .build();

        return usuario;
    }
}
