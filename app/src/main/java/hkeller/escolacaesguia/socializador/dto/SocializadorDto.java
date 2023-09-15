package hkeller.escolacaesguia.socializador.dto;

import hkeller.escolacaesguia.pessoa.PessoaDto;
import hkeller.escolacaesguia.socializador.enums.EnumEstadoCivil;
import hkeller.escolacaesguia.socializador.enums.EnumGrauInstrucao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocializadorDto {
  private String email;
  private String rg;
  private String orgaoEmissor;
  private String endereco;
  private EnumGrauInstrucao grauInstrucao;
  private String profissao;
  private String localTrabalho;
  private boolean estuda;
  private String localEstudo;
  private EnumEstadoCivil estadoCivil;
  private PessoaDto pessoa;

}
