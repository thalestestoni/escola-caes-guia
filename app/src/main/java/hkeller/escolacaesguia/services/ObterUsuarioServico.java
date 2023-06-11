package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.repositories.UserRepository;

@Service
public class ObterUsuarioServico {
    @Autowired
    UserRepository usuarioRepositorio;

    public User execute(Long idUsuario) {
        User usuario = usuarioRepositorio.findById(idUsuario).get();

        return usuario;
    }
}
