package hkeller.escolacaesguia.evento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.cao.model.Cao;
import hkeller.escolacaesguia.evento.model.Evento;
import hkeller.escolacaesguia.evento.repository.EventoRepositorio;

@Service
public class ObterEventosCaoServico {
    @Autowired
    EventoRepositorio eventoRepositorio;

    public Page<Evento> execute(Long idCao, Integer page, Integer size) {
        Pageable paginacao = PageRequest.of(page, size, Sort.by("data").descending());

        Evento evento = Evento.builder().cao(Cao.builder().id(idCao).build()).build();
        Example<Evento> filtro = Example.of(evento);

        Page<Evento> eventos = eventoRepositorio.findAll(filtro, paginacao);

        return eventos;
    }
}
