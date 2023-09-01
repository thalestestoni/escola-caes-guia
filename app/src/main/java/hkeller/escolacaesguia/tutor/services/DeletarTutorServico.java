package hkeller.escolacaesguia.tutor.services;

import hkeller.escolacaesguia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
