package hkeller.escolacaesguia.pessoa.repository;

import hkeller.escolacaesguia.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
