package hkeller.escolacaesguia.atualizarCao.services;

import hkeller.escolacaesguia.atualizarCao.dto.AtualizarCaoDto;
import hkeller.escolacaesguia.atualizarCao.model.AtualizarCao;
import hkeller.escolacaesguia.atualizarCao.repository.AtualizarCaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hkeller.escolacaesguia.atualizarCao.mapper.AtualizarCaoMapper.*;

@Service
public class ObterAtualizacaoCaoServico {
    @Autowired
    AtualizarCaoRepositorio atualizarCaoRepositorio;

    public AtualizarCaoDto execute(Long idAtualizacaoCao) {
        AtualizarCao atualizarCao = atualizarCaoRepositorio.findById(idAtualizacaoCao).get();

        return mapToAtualizarCaoDto(atualizarCao);
    }
}
