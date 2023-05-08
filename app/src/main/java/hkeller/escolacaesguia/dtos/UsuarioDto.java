package hkeller.escolacaesguia.dtos;

import java.util.Date;

import org.checkerframework.common.value.qual.BoolVal;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    private String telefoneCelular;

    private String telefoneFixo;

    // private boolean ativo;
}
