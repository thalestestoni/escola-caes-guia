package hkeller.escolacaesguia.user.services;

import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObterUsuarioServico {
    @Autowired
    UserRepository usuarioRepositorio;

    public User execute(Long idUsuario) {
        User usuario = usuarioRepositorio.findById(idUsuario).get();

        return usuario;
    }
}
