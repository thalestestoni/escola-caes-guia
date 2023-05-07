package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.repositories.CaoRepositorio;

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
