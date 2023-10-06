package hkeller.escolacaesguia.socializador.services;

import hkeller.escolacaesguia.common.mapper.GenericMapper;
import hkeller.escolacaesguia.pessoa.PessoaDto;
import hkeller.escolacaesguia.socializador.dto.SocializadorDto;
import hkeller.escolacaesguia.socializador.entity.SocializadorEntity;
import hkeller.escolacaesguia.socializador.repository.SocializadorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {SocializadorService.class})
@ExtendWith(SpringExtension.class)
class SocializadorEntityServiceTest {
    @MockBean
    private GenericMapper<SocializadorEntity, SocializadorDto> genericMapper;

    @MockBean
    private SocializadorRepository socializadorRepository;

    @Autowired
    private SocializadorService socializadorService;

    @Test
    void testInsert() {

        when(socializadorRepository.save(Mockito.<SocializadorEntity>any())).thenReturn(new SocializadorEntity());

        PessoaDto pessoa = new PessoaDto();
        pessoa.setCpf("12345678910");
        pessoa.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        pessoa.setNome("Joao Sem Braco");
        pessoa.setTelefoneCelular("00011000");
        pessoa.setTelefoneFixo("00011000");

        SocializadorDto dto = new SocializadorDto();
        dto.setEmail("jane.doe@example.org");
        dto.setEndereco("Endereco");
        dto.setEstuda(true);
        dto.setLocalEstudo("Local Estudo");
        dto.setLocalTrabalho("Local Trabalho");
        dto.setOrgaoEmissor("Orgao Emissor");
        dto.setPessoa(pessoa);
        dto.setProfissao("Profissao");
        dto.setRg("123456789");
        socializadorService.insert(dto);
        verify(genericMapper).toEntity(Mockito.<SocializadorDto>any(), Mockito.<Class<SocializadorEntity>>any());
        verify(socializadorRepository).save(Mockito.<SocializadorEntity>any());
    }
}

