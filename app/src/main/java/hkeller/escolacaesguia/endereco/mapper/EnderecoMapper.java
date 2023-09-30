package hkeller.escolacaesguia.endereco.mapper;

import hkeller.escolacaesguia.endereco.dtos.EnderecoDto;
import hkeller.escolacaesguia.endereco.model.Endereco;

public class EnderecoMapper {
  public static EnderecoDto toDto(Endereco endereco) {
    EnderecoDto dto = EnderecoDto.builder()
      .cep(endereco.getCep())
      .logradouro(endereco.getLogradouro())
      .numero(endereco.getNumero())
      .bairro(endereco.getBairro())
      .cidade(endereco.getCidade().getNome())
      .estado(endereco.getEstado().getNome())
      .build();

    return dto;
  }
}
