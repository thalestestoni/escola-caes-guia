package hkeller.escolacaesguia.evento.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoCadastroEventoDto {
    @NotNull
    private Long idCao;

    @NotEmpty(message = "Por favor informe o título")
    private String titulo;

    @NotEmpty(message = "Por favor informe a descrição")
    private String descricao;

    @NotNull(message = "Por favor informe a data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    private boolean notificarTutor;

    public RequisicaoCadastroEventoDto(Long idCao) {
        this.idCao = idCao;
    }
}
