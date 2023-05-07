package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.repositories.CaoRepositorio;
import hkeller.escolacaesguia.dtos.CaoDto;
import hkeller.escolacaesguia.models.Cao;

import static hkeller.escolacaesguia.mapper.CaoMapper.mapToCaoDto;

@Service
public class ObterCaoServico {
    @Autowired
    CaoRepositorio caoRepositorio;

    public CaoDto execute(Long idCao) {
        Cao cao = caoRepositorio.findById(idCao).get();

        return mapToCaoDto(cao);
    }
}
