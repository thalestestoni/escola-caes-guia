package hkeller.escolacaesguia.visita.services;

import hkeller.escolacaesguia.visita.model.Visita;
import hkeller.escolacaesguia.visita.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitaService {

  private final VisitaRepository visitaRepository;

  @Autowired
  public VisitaService(VisitaRepository visitaRepository) {
    this.visitaRepository = visitaRepository;
  }

  public List<Visita> getAllVisitas() {
    return visitaRepository.findAll();
  }

  public Visita getVisitaById(long id) {
    return visitaRepository.getReferenceById(id);
  }

  public Visita save(Visita visita) {
    return visitaRepository.save(visita);
  }

  public Page<Visita> pagina(Integer page, Integer size) {
      return visitaRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
  }
}
