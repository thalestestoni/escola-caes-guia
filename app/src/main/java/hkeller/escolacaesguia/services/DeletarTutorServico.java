package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.repositories.UserRepository;

@Service
public class DeletarTutorServico {
    @Autowired
    UserRepository usuarioRepositorio;

    public void execute(Long id) {
        try {
            usuarioRepositorio.deleteById(id);
        }
        catch (Exception exception) {
            // TODO
        }
    }
}
