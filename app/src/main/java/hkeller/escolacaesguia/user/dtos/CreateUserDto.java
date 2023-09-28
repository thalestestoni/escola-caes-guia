package hkeller.escolacaesguia.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CreateUserDto {

    @NotBlank(message = "Por favor informe o nome")
    private String nome;

    @NotBlank(message = "Por favor informe o email")
    @Email
    private String email;

    @NotBlank(message = "Por favor informe o CPF")
    @Size(max = 11)
    private String cpf;

    // @NotBlank
    // @Size(min = 8)
    private String password;

    @NotNull(message = "Por favor informe a data de nascimento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @NotBlank(message = "Por favor informe o telefone celular")
    private String telefoneCelular;

    private String telefoneFixo;

    private boolean ativo;
}
