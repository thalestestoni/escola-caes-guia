package hkeller.escolacaesguia.visita.repository;

import hkeller.escolacaesguia.visita.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long> {
  // Você pode adicionar consultas personalizadas aqui, se necessário
}
