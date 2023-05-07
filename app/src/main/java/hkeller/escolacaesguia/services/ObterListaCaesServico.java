package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.models.Cao;
import hkeller.escolacaesguia.repositories.CaoRepositorio;

@Service
public class ObterListaCaesServico {
    @Autowired
    CaoRepositorio caoRepositorio;

    public Page<Cao> execute(Integer page, Integer size) {
        Page<Cao> caes = caoRepositorio.findAll(PageRequest.of(page, size));

        return caes;
    }
}