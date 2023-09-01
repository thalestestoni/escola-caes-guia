package hkeller.escolacaesguia.cao.services;

import hkeller.escolacaesguia.cao.dto.CaoDto;
import hkeller.escolacaesguia.cao.model.Cao;
import hkeller.escolacaesguia.cao.repository.CaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hkeller.escolacaesguia.cao.mapper.CaoMapper.mapToCaoDto;

@Service
public class ObterCaoServico {
    @Autowired
    CaoRepositorio caoRepositorio;

    public CaoDto execute(Long idCao) {
        Cao cao = caoRepositorio.findById(idCao).get();

        return mapToCaoDto(cao);
    }
}
