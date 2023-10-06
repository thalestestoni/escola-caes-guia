package hkeller.escolacaesguia.pessoa.repository;

import hkeller.escolacaesguia.pessoa.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
