package hkeller.escolacaesguia.tutor.services;

import hkeller.escolacaesguia.tutor.dtos.CadastroTutorDto;
import hkeller.escolacaesguia.user.mapper.UsuarioMapper;
import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.services.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarTutorServico {
    @Autowired
    CreateUserService criarUsuarioServico;

    public void execute(CadastroTutorDto cadastroTutorDto) {
        // TODO: gerar uma senha aleatoria dificil
        cadastroTutorDto.setPassword("12345678");

        User usuario = UsuarioMapper.mapToUsuario(cadastroTutorDto);

        criarUsuarioServico.execute(usuario);
    }
}
