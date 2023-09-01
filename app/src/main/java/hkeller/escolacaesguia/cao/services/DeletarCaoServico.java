package hkeller.escolacaesguia.cao.services;

import hkeller.escolacaesguia.cao.repository.CaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarCaoServico {
    @Autowired
    CaoRepositorio caoRepositorio;

    public void execute(Long id) {
        try {
            caoRepositorio.deleteById(id);
        }
        catch (Exception exception) {
            // TODO
        }
    }
}
