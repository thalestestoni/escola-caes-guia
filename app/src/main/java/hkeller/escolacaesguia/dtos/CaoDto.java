package hkeller.escolacaesguia.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaoDto {
    private String nome;
    
    private String cor;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    
    private String genero;
}
