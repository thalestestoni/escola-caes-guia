package hkeller.escolacaesguia.pessoa;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class PessoaDto {
  private String nome;
  private String cpf;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dataNascimento;
  private String telefoneCelular;
  private String telefoneFixo;

}
