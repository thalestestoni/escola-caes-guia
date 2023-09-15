package hkeller.escolacaesguia.socializador.services;

import hkeller.escolacaesguia.socializador.model.Socializador;
import hkeller.escolacaesguia.socializador.repository.SocializadorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocializadorService {

  private final SocializadorRepository socializadorRepository;

  public SocializadorService(SocializadorRepository socializadorRepository) {
    this.socializadorRepository = socializadorRepository;
  }

  public void insert(Socializador entity) {
    socializadorRepository.save(entity);
  }

  public void update(Socializador entity) {
    socializadorRepository.save(entity);
  }
  public Socializador get(long id) {
    Optional<Socializador> socializador = socializadorRepository.findById(id);
    return socializador.orElse(null);
  }
}
