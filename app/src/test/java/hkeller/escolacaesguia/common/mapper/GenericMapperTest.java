package hkeller.escolacaesguia.common.mapper;

import hkeller.escolacaesguia.pessoa.Pessoa;
import hkeller.escolacaesguia.pessoa.PessoaDto;
import hkeller.escolacaesguia.socializador.dto.SocializadorDto;
import hkeller.escolacaesguia.socializador.model.Socializador;
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
  private GenericMapper<Socializador, SocializadorDto> genericMapper;
  @Autowired
  private GenericMapper<Pessoa, PessoaDto> genericPessoaMapper;

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

    Socializador socializador = this.genericMapper.toEntity(socializadorDto, Socializador.class);
    socializador.setPessoa(genericPessoaMapper.toEntity(socializadorDto.getPessoa(), Pessoa.class));
    Socializador expectedSocializador = new Socializador();
    expectedSocializador.setEmail("123456789");
    expectedSocializador.setRg("Rg");
    expectedSocializador.setEndereco("Endereco");
    expectedSocializador.setEstuda(true);
    expectedSocializador.setLocalEstudo("Local Estudo");
    expectedSocializador.setLocalTrabalho("Local Trabalho");
    expectedSocializador.setOrgaoEmissor("Orgao Emissor");
    expectedSocializador.setProfissao("Profissao");

    Pessoa pessoa = new Pessoa();
    pessoa.setCpf("12345678910");
    pessoa.setNome("Nome");
    pessoa.setTelefoneCelular("Telefone Celular");
    pessoa.setTelefoneFixo("Telefone Fixo");
    expectedSocializador.setPessoa(pessoa);

    assertEquals(socializador.getEmail(), expectedSocializador.getEmail());
    assertEquals(socializador.getRg(), expectedSocializador.getRg());
    assertEquals(socializador.getEndereco(), expectedSocializador.getEndereco());
    assertEquals(socializador.isEstuda(), expectedSocializador.isEstuda());
    assertEquals(socializador.getLocalEstudo(), expectedSocializador.getLocalEstudo());
    assertEquals(socializador.getLocalTrabalho(), expectedSocializador.getLocalTrabalho());
    assertEquals(socializador.getOrgaoEmissor(), expectedSocializador.getOrgaoEmissor());
    assertEquals(socializador.getProfissao(), expectedSocializador.getProfissao());

    assertEquals(socializador.getPessoa().getCpf(), expectedSocializador.getPessoa().getCpf());
    assertEquals(socializador.getPessoa().getNome(), expectedSocializador.getPessoa().getNome());
    assertEquals(socializador.getPessoa().getTelefoneCelular(), expectedSocializador.getPessoa().getTelefoneCelular());
    assertEquals(socializador.getPessoa().getTelefoneFixo(), expectedSocializador.getPessoa().getTelefoneFixo());

  }

}

