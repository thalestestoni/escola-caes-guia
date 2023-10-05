package hkeller.escolacaesguia.tutor.services;

import hkeller.escolacaesguia.user.dtos.UsuarioDto;
import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.repositories.UserRepository;
import hkeller.escolacaesguia.user.services.ObterUsuarioServico;
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

        usuario.getPessoa().setNome(usuarioDto.getNome());
        usuario.getPessoa().setCpf(usuarioDto.getCpf());
        usuario.getPessoa().setDataNascimento(usuarioDto.getDataNascimento());
        usuario.getPessoa().setTelefoneCelular(usuarioDto.getTelefoneCelular());
        usuario.getPessoa().setTelefoneFixo(usuarioDto.getTelefoneFixo());

        usuarioRepositorio.save(usuario);
    }
}
