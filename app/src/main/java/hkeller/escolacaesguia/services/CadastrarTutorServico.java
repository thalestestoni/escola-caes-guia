package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.dtos.CadastroTutorDto;
import hkeller.escolacaesguia.models.User;

import static hkeller.escolacaesguia.mapper.UsuarioMapper.mapToUsuario;

@Service
public class CadastrarTutorServico {
    @Autowired
    CreateUserService criarUsuarioServico;

    public void execute(CadastroTutorDto cadastroTutorDto) {
        // TODO: gerar uma senha aleatoria dificil
        cadastroTutorDto.setPassword("12345678");

        User usuario = mapToUsuario(cadastroTutorDto);
        
        criarUsuarioServico.execute(usuario);
    }
}
