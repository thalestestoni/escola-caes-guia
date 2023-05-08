package hkeller.escolacaesguia.mapper;

import hkeller.escolacaesguia.dtos.CadastroTutorDto;
import hkeller.escolacaesguia.dtos.UsuarioDto;
import hkeller.escolacaesguia.models.User;

public class UsuarioMapper {
    public static UsuarioDto mapToUsuarioDto(User user) {
        UsuarioDto usuarioDto = UsuarioDto.builder()
            .id(user.getId())
            .nome(user.getNome())
            .cpf(user.getCpf())
            .email(user.getEmail())
            .telefoneCelular(user.getTelefoneCelular())
            .telefoneFixo(user.getTelefoneFixo())
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
}
