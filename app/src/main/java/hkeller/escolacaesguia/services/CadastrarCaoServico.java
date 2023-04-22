package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.models.Cao;
import hkeller.escolacaesguia.repositories.CaoRepositorio;

@Service
public class CadastrarCaoServico {
    @Autowired
    CaoRepositorio caoRepositorio;
    
    public void executar(Cao cao) {
        caoRepositorio.save(cao);    
    }
}
