package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.dtos.CaoDto;
import hkeller.escolacaesguia.dtos.RequisicaoCadastroEventoDto;
import hkeller.escolacaesguia.models.Cao;
import hkeller.escolacaesguia.models.Evento;
import hkeller.escolacaesguia.repositories.EventoRepositorio;

import static hkeller.escolacaesguia.mapper.EventoMapper.mapToEvento;
import static hkeller.escolacaesguia.mapper.CaoMapper.mapToCao;;

@Service
public class CadastrarEventoServico {
    @Autowired
    EventoRepositorio eventoRepositorio;

    public void execute(CaoDto caoDto, RequisicaoCadastroEventoDto eventoDto) {
        Cao cao = mapToCao(caoDto);
        Evento evento = mapToEvento(eventoDto);
        evento.setCao(cao);

        eventoRepositorio.save(evento);
    }
}
