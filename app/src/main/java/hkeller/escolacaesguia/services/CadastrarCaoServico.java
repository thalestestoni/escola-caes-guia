package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.dtos.RequisicaoCadastroCaoDto;
import hkeller.escolacaesguia.models.Cao;
import hkeller.escolacaesguia.repositories.CaoRepositorio;

import static hkeller.escolacaesguia.mapper.CaoMapper.mapToCao;

@Service
public class CadastrarCaoServico {
    @Autowired
    CaoRepositorio caoRepositorio;
    
    public void executar(RequisicaoCadastroCaoDto caoDto) {
        Cao cao = mapToCao(caoDto);
        
        caoRepositorio.save(cao);    
    }
}
