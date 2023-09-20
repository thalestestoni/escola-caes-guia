package hkeller.escolacaesguia.socializador.services;

import hkeller.escolacaesguia.common.mapper.GenericMapper;
import hkeller.escolacaesguia.pessoa.Pessoa;
import hkeller.escolacaesguia.pessoa.PessoaDto;
import hkeller.escolacaesguia.socializador.dto.SocializadorDto;
import hkeller.escolacaesguia.socializador.model.Socializador;
import hkeller.escolacaesguia.socializador.repository.SocializadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocializadorService {

  private final SocializadorRepository socializadorRepository;
  @Autowired
  private GenericMapper<Socializador, SocializadorDto> socializadorMapper;
  @Autowired
  private GenericMapper<Pessoa, PessoaDto> pessoaMapper;

  public SocializadorService(SocializadorRepository socializadorRepository) {
    this.socializadorRepository = socializadorRepository;
  }

  public void insert(SocializadorDto dto) {
    Socializador socializador = socializadorMapper.toEntity(dto, Socializador.class);
    socializador.setPessoa(pessoaMapper.toEntity(dto.getPessoa(), Pessoa.class));
    socializadorRepository.save(socializador);
  }

  public void update(Socializador entity) {
    socializadorRepository.save(entity);
  }
  public Socializador get(long id) {
    Optional<Socializador> socializador = socializadorRepository.findById(id);
    return socializador.orElse(null);
  }
}
