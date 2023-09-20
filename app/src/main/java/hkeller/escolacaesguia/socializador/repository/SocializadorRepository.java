package hkeller.escolacaesguia.socializador.repository;

import hkeller.escolacaesguia.socializador.model.Socializador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocializadorRepository extends JpaRepository<Socializador, Long> {
  Socializador findByEmailLike(String email);
}
