package hkeller.escolacaesguia.socializador.services;

import hkeller.escolacaesguia.common.mapper.GenericMapper;
import hkeller.escolacaesguia.pessoa.PessoaEntity;
import hkeller.escolacaesguia.pessoa.PessoaDto;
import hkeller.escolacaesguia.pessoa.repository.PessoaRepository;
import hkeller.escolacaesguia.socializador.dto.SocializadorDto;
import hkeller.escolacaesguia.socializador.entity.SocializadorEntity;
import hkeller.escolacaesguia.socializador.repository.SocializadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocializadorService {

  private final SocializadorRepository socializadorRepository;
  private final PessoaRepository pessoaRepository;

  @Autowired
  private GenericMapper<SocializadorEntity, SocializadorDto> socializadorMapper;
  @Autowired
  private GenericMapper<PessoaEntity, PessoaDto> pessoaMapper;

  public SocializadorService(SocializadorRepository socializadorRepository, PessoaRepository pessoaRepository, GenericMapper<SocializadorEntity, SocializadorDto> socializadorMapper) {
    this.socializadorRepository = socializadorRepository;
    this.pessoaRepository = pessoaRepository;
    this.socializadorMapper = socializadorMapper;
  }

  public void insert(SocializadorDto dto) {
    SocializadorEntity socializadorEntity = socializadorMapper.toEntity(dto, SocializadorEntity.class);
    socializadorEntity.setPessoaEntity(pessoaMapper.toEntity(dto.getPessoa(), PessoaEntity.class));
    pessoaRepository.save(socializadorEntity.getPessoaEntity());
    socializadorRepository.save(socializadorEntity);
  }

  public void update(SocializadorEntity entity) {
    socializadorRepository.save(entity);
  }
  public SocializadorEntity get(long id) {
    Optional<SocializadorEntity> socializador = socializadorRepository.findById(id);
    return socializador.orElse(null);
  }
}
