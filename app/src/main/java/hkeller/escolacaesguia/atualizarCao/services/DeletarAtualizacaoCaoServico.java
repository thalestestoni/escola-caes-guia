package hkeller.escolacaesguia.atualizarCao.services;

import hkeller.escolacaesguia.atualizarCao.repository.AtualizarCaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarAtualizacaoCaoServico {
    @Autowired
    AtualizarCaoRepositorio atualizarCaoRepositorio;

    public void execute(Long id) {
        try {
          atualizarCaoRepositorio.deleteById(id);
        }
        catch (Exception exception) {
            // TODO
        }
    }
}
