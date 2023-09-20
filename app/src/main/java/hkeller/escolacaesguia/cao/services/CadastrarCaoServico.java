package hkeller.escolacaesguia.cao.services;

import hkeller.escolacaesguia.cao.dto.RequisicaoCadastroCaoDto;
import hkeller.escolacaesguia.cao.model.Cao;
import hkeller.escolacaesguia.cao.repository.CaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hkeller.escolacaesguia.cao.mapper.CaoMapper.mapToCao;

@Service
public class CadastrarCaoServico {
    @Autowired
    CaoRepositorio caoRepositorio;

    public void executar(RequisicaoCadastroCaoDto caoDto) {
        Cao cao = mapToCao(caoDto);

        caoRepositorio.save(cao);
    }
}
