package hkeller.escolacaesguia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hkeller.escolacaesguia.models.Evento;

public interface EventoRepositorio extends JpaRepository<Evento, Long> {
    
}
