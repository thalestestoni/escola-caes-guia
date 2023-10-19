package hkeller.escolacaesguia.atualizarCao.services;

import hkeller.escolacaesguia.atualizarCao.model.AtualizarCao;
import hkeller.escolacaesguia.atualizarCao.repository.AtualizarCaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ObterListaAtualizacoesCaesServico {
    @Autowired
    AtualizarCaoRepositorio atualizarCaoRepositorio;

    public Page<AtualizarCao> execute(Integer page, Integer size) {
        Page<AtualizarCao> atualizarCaes = atualizarCaoRepositorio.findAll(PageRequest.of(page, size, Sort.by("id").descending()));

        return atualizarCaes;
    }
}
