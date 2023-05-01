package hkeller.escolacaesguia.mapper;

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
}
