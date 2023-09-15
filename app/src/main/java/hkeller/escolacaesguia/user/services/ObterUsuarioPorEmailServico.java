package hkeller.escolacaesguia.user.services;

import hkeller.escolacaesguia.user.dtos.UsuarioDto;
import hkeller.escolacaesguia.user.mapper.UsuarioMapper;
import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObterUsuarioPorEmailServico {
    @Autowired
    UserRepository userRepository;

    public UsuarioDto execute(String email) {
        User user = userRepository.findByEmail(email);

        UsuarioDto usuarioDto = UsuarioMapper.mapToUsuarioDto(user);

        return usuarioDto;
    }
}
