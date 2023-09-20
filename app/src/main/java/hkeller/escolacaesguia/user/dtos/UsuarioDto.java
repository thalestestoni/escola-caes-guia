package hkeller.escolacaesguia.user.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
