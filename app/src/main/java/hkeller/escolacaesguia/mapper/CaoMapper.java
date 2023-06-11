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
            .sexo(caoDto.getSexo())
            .build();

        return cao;
    }

    public static Cao mapToCao(CaoDto caoDto) {
        Cao cao =  Cao.builder()
            .id(caoDto.getId())
            .nome(caoDto.getNome())
            .cor(caoDto.getCor())
            .dataNascimento(caoDto.getDataNascimento())
            .sexo(caoDto.getSexo())
            .build();

        return cao;
    }

    public static List<CaoDto> mapToCaoDto(List<Cao> caes) {
        List<CaoDto> caesDto = new ArrayList<CaoDto>();
        
        for(Cao cao : caes) {
            caesDto.add(
                CaoDto.builder()
                    .id(cao.getId())
                    .nome(cao.getNome())
                    .cor(cao.getCor())
                    .dataNascimento(cao.getDataNascimento())
                    .sexo(cao.getSexo())
                    .build()
            );
        };

        return caesDto;
    }

    public static CaoDto mapToCaoDto(Cao cao) {
        CaoDto caoDto = CaoDto.builder()
                            .id(cao.getId())
                            .nome(cao.getNome())
                            .cor(cao.getCor())
                            .dataNascimento(cao.getDataNascimento())
                            .sexo(cao.getSexo())
                            .build();

        return caoDto;
    }
}
