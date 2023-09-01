package hkeller.escolacaesguia.evento.repository;

import hkeller.escolacaesguia.evento.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepositorio extends JpaRepository<Evento, Long> {

}
