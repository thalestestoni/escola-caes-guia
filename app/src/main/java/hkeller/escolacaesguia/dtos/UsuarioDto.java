package hkeller.escolacaesguia.dtos;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private Date dataNascimento;

    private String telefoneCelular;

    private String telefoneFixo;

    private boolean ativo;
}
