package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.dtos.UsuarioDto;
import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.repositories.UserRepository;

import static hkeller.escolacaesguia.mapper.UsuarioMapper.mapToUsuarioDto;

@Service
public class ObterUsuarioPorEmailServico {
    @Autowired
    UserRepository userRepository;

    public UsuarioDto execute(String email) {
        User user = userRepository.findByEmail(email);

        UsuarioDto usuarioDto = mapToUsuarioDto(user);

        return usuarioDto;
    }
}
