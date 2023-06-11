package hkeller.escolacaesguia.services;

import hkeller.escolacaesguia.dtos.UsuarioDto;
import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditarTutorServico {
    @Autowired
    UserRepository usuarioRepositorio;

    @Autowired
    ObterUsuarioServico obterUsuarioServico;

    public void execute(UsuarioDto usuarioDto) {
        User usuario = obterUsuarioServico.execute(usuarioDto.getId());

        usuario.setNome(usuarioDto.getNome());
        usuario.setCpf(usuarioDto.getCpf());
        usuario.setDataNascimento(usuarioDto.getDataNascimento());
        usuario.setTelefoneCelular(usuarioDto.getTelefoneCelular());
        usuario.setTelefoneFixo(usuarioDto.getTelefoneFixo());

        usuarioRepositorio.save(usuario);
    }
}
