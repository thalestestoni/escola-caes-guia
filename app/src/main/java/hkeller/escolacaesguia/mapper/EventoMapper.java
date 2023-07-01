package hkeller.escolacaesguia.mapper;

import hkeller.escolacaesguia.dtos.RequisicaoCadastroEventoDto;
import hkeller.escolacaesguia.models.Evento;

public class EventoMapper {
    public static Evento mapToEvento(RequisicaoCadastroEventoDto eventoDto) {
        Evento evento = Evento.builder()
            .titulo(eventoDto.getTitulo())
            .descricao(eventoDto.getDescricao())
            .data(eventoDto.getData())
            .notificarTutor(eventoDto.isNotificarTutor())
            .build();
        
        return evento;
    }
}
