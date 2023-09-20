package hkeller.escolacaesguia.cao.services;

import hkeller.escolacaesguia.cao.model.Cao;
import hkeller.escolacaesguia.cao.repository.CaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ObterListaCaesServico {
    @Autowired
    CaoRepositorio caoRepositorio;

    public Page<Cao> execute(Integer page, Integer size) {
        Page<Cao> caes = caoRepositorio.findAll(PageRequest.of(page, size, Sort.by("id").descending()));

        return caes;
    }
}
