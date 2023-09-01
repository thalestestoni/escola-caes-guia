package hkeller.escolacaesguia.user.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlteracaoSenhaDto {
    @NotBlank(message = "Campo obrigatório")
    private String senhaAtual;

    @NotBlank(message = "Campo obrigatório")
    private String senhaNova;

    @NotBlank(message = "Campo obrigatório")
    private String confirmacaoSenhaNova;
}
