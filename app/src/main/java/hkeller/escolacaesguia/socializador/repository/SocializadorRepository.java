package hkeller.escolacaesguia.socializador.repository;

import hkeller.escolacaesguia.socializador.entity.SocializadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SocializadorRepository extends JpaRepository<SocializadorEntity, Long> {
  SocializadorEntity findByEmailLike(String email);
}
