package hkeller.escolacaesguia.common.mapper;

import hkeller.escolacaesguia.pessoa.PessoaEntity;
import hkeller.escolacaesguia.pessoa.PessoaDto;
import hkeller.escolacaesguia.socializador.dto.SocializadorDto;
import hkeller.escolacaesguia.socializador.entity.SocializadorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {GenericMapper.class})
@ExtendWith(SpringExtension.class)
class GenericMapperTest {
  @Autowired
  private GenericMapper<SocializadorEntity, SocializadorDto> genericMapper;
  @Autowired
  private GenericMapper<PessoaEntity, PessoaDto> genericPessoaMapper;

  @Test
  void testToEntity() {
    SocializadorDto socializadorDto = new SocializadorDto();
    socializadorDto.setEmail("123456789");
    socializadorDto.setRg("Rg");
    socializadorDto.setEndereco("Endereco");
    socializadorDto.setEstuda(true);
    socializadorDto.setLocalEstudo("Local Estudo");
    socializadorDto.setLocalTrabalho("Local Trabalho");
    socializadorDto.setOrgaoEmissor("Orgao Emissor");
    socializadorDto.setProfissao("Profissao");

    PessoaDto pessoaDto = new PessoaDto();
    pessoaDto.setCpf("12345678910");
    pessoaDto.setNome("Nome");
    pessoaDto.setTelefoneCelular("Telefone Celular");
    pessoaDto.setTelefoneFixo("Telefone Fixo");
    socializadorDto.setPessoa(pessoaDto);

    SocializadorEntity socializadorEntity = this.genericMapper.toEntity(socializadorDto, SocializadorEntity.class);
    socializadorEntity.setPessoaEntity(genericPessoaMapper.toEntity(socializadorDto.getPessoa(), PessoaEntity.class));
    SocializadorEntity expectedSocializadorEntity = new SocializadorEntity();
    expectedSocializadorEntity.setEmail("123456789");
    expectedSocializadorEntity.setRg("Rg");
    expectedSocializadorEntity.setEndereco("Endereco");
    expectedSocializadorEntity.setEstuda(true);
    expectedSocializadorEntity.setLocalEstudo("Local Estudo");
    expectedSocializadorEntity.setLocalTrabalho("Local Trabalho");
    expectedSocializadorEntity.setOrgaoEmissor("Orgao Emissor");
    expectedSocializadorEntity.setProfissao("Profissao");

    PessoaEntity pessoaEntity = new PessoaEntity();
    pessoaEntity.setCpf("12345678910");
    pessoaEntity.setNome("Nome");
    pessoaEntity.setTelefoneCelular("Telefone Celular");
    pessoaEntity.setTelefoneFixo("Telefone Fixo");
    expectedSocializadorEntity.setPessoaEntity(pessoaEntity);

    assertEquals(socializadorEntity.getEmail(), expectedSocializadorEntity.getEmail());
    assertEquals(socializadorEntity.getRg(), expectedSocializadorEntity.getRg());
    assertEquals(socializadorEntity.getEndereco(), expectedSocializadorEntity.getEndereco());
    assertEquals(socializadorEntity.isEstuda(), expectedSocializadorEntity.isEstuda());
    assertEquals(socializadorEntity.getLocalEstudo(), expectedSocializadorEntity.getLocalEstudo());
    assertEquals(socializadorEntity.getLocalTrabalho(), expectedSocializadorEntity.getLocalTrabalho());
    assertEquals(socializadorEntity.getOrgaoEmissor(), expectedSocializadorEntity.getOrgaoEmissor());
    assertEquals(socializadorEntity.getProfissao(), expectedSocializadorEntity.getProfissao());

    assertEquals(socializadorEntity.getPessoaEntity().getCpf(), expectedSocializadorEntity.getPessoaEntity().getCpf());
    assertEquals(socializadorEntity.getPessoaEntity().getNome(), expectedSocializadorEntity.getPessoaEntity().getNome());
    assertEquals(socializadorEntity.getPessoaEntity().getTelefoneCelular(), expectedSocializadorEntity.getPessoaEntity().getTelefoneCelular());
    assertEquals(socializadorEntity.getPessoaEntity().getTelefoneFixo(), expectedSocializadorEntity.getPessoaEntity().getTelefoneFixo());

  }

}

