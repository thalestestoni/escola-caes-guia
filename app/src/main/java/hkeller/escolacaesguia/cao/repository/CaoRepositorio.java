package hkeller.escolacaesguia.cao.repository;

import hkeller.escolacaesguia.cao.model.Cao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaoRepositorio extends JpaRepository<Cao, Long> {


}
