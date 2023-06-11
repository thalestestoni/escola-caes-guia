package hkeller.escolacaesguia.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoCadastroCaoDto {
    @NotEmpty(message = "Por favor informe o nome")
    private String nome;
    
    @NotEmpty(message = "Por favor informe a cor")
    private String cor;
    
    @NotNull(message = "Por favor informe a data de nascimento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    
    @NotEmpty(message = "Por favor informe o gênero")
    private String genero;
}
