package hkeller.escolacaesguia.evento.services;

import hkeller.escolacaesguia.cao.dto.CaoDto;
import hkeller.escolacaesguia.cao.model.Cao;
import hkeller.escolacaesguia.evento.dto.RequisicaoCadastroEventoDto;
import hkeller.escolacaesguia.evento.mapper.EventoMapper;
import hkeller.escolacaesguia.evento.model.Evento;
import hkeller.escolacaesguia.evento.repository.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hkeller.escolacaesguia.cao.mapper.CaoMapper.mapToCao;

;

@Service
public class CadastrarEventoServico {
    @Autowired
    EventoRepositorio eventoRepositorio;

    public void execute(CaoDto caoDto, RequisicaoCadastroEventoDto eventoDto) {
        Cao cao = mapToCao(caoDto);
        Evento evento = EventoMapper.mapToEvento(eventoDto);
        evento.setCao(cao);

        eventoRepositorio.save(evento);
    }
}
