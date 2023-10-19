package hkeller.escolacaesguia.atualizarCao.services;

import hkeller.escolacaesguia.atualizarCao.dto.RequisicaoCadastroAtualizarCaoDto;
import hkeller.escolacaesguia.atualizarCao.model.AtualizarCao;
import hkeller.escolacaesguia.atualizarCao.repository.AtualizarCaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static hkeller.escolacaesguia.atualizarCao.mapper.AtualizarCaoMapper.*;


@Service
public class CadastrarAtualizacaoCaoServico {
    @Autowired
    AtualizarCaoRepositorio atualizarCaoRepositorio;

    public void executar(RequisicaoCadastroAtualizarCaoDto atualizarCaoDto) {
      AtualizarCao atualizarCao = mapToAtualizarCao(atualizarCaoDto);

      atualizarCaoRepositorio.save(atualizarCao);
    }
}
