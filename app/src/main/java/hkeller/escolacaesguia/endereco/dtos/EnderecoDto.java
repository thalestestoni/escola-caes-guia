package hkeller.escolacaesguia.endereco.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDto {
  private int cep;
  private String logradouro;
  private String numero;
  private String bairro;
  private String cidade;
  private String estado;
}
