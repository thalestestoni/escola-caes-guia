package hkeller.escolacaesguia.socializador.services;

import hkeller.escolacaesguia.common.interfaces.IInsertPersistencePort;
import hkeller.escolacaesguia.common.interfaces.IGetPersistencePort;
import hkeller.escolacaesguia.common.interfaces.IUpdatePersistencePort;
import hkeller.escolacaesguia.socializador.model.Socializador;
import hkeller.escolacaesguia.socializador.repository.SocializadorRepository;
import org.springframework.stereotype.Service;

@Service
public class SocializadorService implements IInsertPersistencePort<Socializador>, IUpdatePersistencePort<Socializador>, IGetPersistencePort<Socializador> {

  private final SocializadorRepository socializadorRepository;

  public SocializadorService(SocializadorRepository socializadorRepository) {
    this.socializadorRepository = socializadorRepository;
  }

  @Override
  public void insert(Socializador entity) {
    socializadorRepository.save(entity);
  }

  @Override
  public void update(Socializador entity) {
    socializadorRepository.save(entity);
  }

  @Override
  public Socializador get(long id) {
    return socializadorRepository.findById(id).get();
  }
}
