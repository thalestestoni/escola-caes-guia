package hkeller.escolacaesguia.mapper;

import java.util.ArrayList;
import java.util.List;

import hkeller.escolacaesguia.dtos.CaoDto;
import hkeller.escolacaesguia.dtos.RequisicaoCadastroCaoDto;
import hkeller.escolacaesguia.models.Cao;

public class CaoMapper {
    public static Cao mapToCao(RequisicaoCadastroCaoDto caoDto) {
        Cao cao =  Cao.builder()
            .nome(caoDto.getNome())
            .cor(caoDto.getCor())
            .dataNascimento(caoDto.getDataNascimento())
            .genero(caoDto.getGenero())
            .build();

        return cao;
    }

    public static List<CaoDto> mapToCaoDto(List<Cao> caes) {
        List<CaoDto> caesDto = new ArrayList<CaoDto>();
        
        for(Cao cao : caes) {
            caesDto.add(
                CaoDto.builder()
                    .nome(cao.getNome())
                    .cor(cao.getCor())
                    .dataNascimento(cao.getDataNascimento())
                    .genero(cao.getGenero())
                    .build()
            );
        };

        return caesDto;
    }
}
