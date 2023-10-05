package hkeller.escolacaesguia.endereco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hkeller.escolacaesguia.endereco.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

  Optional<Endereco> findByCep(int cep);
}
