package hkeller.escolacaesguia.user.mapper;

import hkeller.escolacaesguia.pessoa.Pessoa;
import hkeller.escolacaesguia.tutor.dtos.CadastroTutorDto;
import hkeller.escolacaesguia.user.dtos.UsuarioDto;
import hkeller.escolacaesguia.user.models.User;

public class UsuarioMapper {
    public static UsuarioDto mapToUsuarioDto(User user) {
        UsuarioDto usuarioDto = UsuarioDto.builder()
            .id(user.getId())
            .nome(user.getPessoa().getNome())
            .cpf(user.getPessoa().getCpf())
            .email(user.getEmail())
            .telefoneCelular(user.getPessoa().getTelefoneCelular())
            .telefoneFixo(user.getPessoa().getTelefoneFixo())
            .password(user.getPassword())
            .dataNascimento(user.getPessoa().getDataNascimento())
            // .ativo(user.isAtivo())
            .build();

        return usuarioDto;
    }

    public static User mapToUsuario(CadastroTutorDto cadastroTutorDto) {
        User usuario = User.builder()
            .pessoa(
              Pessoa.builder()
                .nome(cadastroTutorDto.getNome())
                .cpf(cadastroTutorDto.getCpf())
                .dataNascimento(cadastroTutorDto.getDataNascimento())
                .telefoneCelular(cadastroTutorDto.getTelefoneCelular())
                .telefoneFixo(cadastroTutorDto.getTelefoneFixo())
                .build()
            )
            .email(cadastroTutorDto.getEmail())
            .password(cadastroTutorDto.getPassword())
            .build();

        return usuario;
    }

    public static User mapToUsuario(UsuarioDto usuarioDto) {
        User usuario = User.builder()
            .id(usuarioDto.getId())
            .email(usuarioDto.getEmail())
            .password(usuarioDto.getPassword())
            .password(usuarioDto.getPassword())
            .pessoa(
              Pessoa.builder()
                .nome(usuarioDto.getNome())
                .cpf(usuarioDto.getCpf())
                .dataNascimento(usuarioDto.getDataNascimento())
                .telefoneCelular(usuarioDto.getTelefoneCelular())
                .telefoneFixo(usuarioDto.getTelefoneFixo())
                // .ativo(usuarioDto.isAtivo())
                .build()
            )
            .build();

        return usuario;
    }
}
