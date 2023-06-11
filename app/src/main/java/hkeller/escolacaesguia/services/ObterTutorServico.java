package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.dtos.UsuarioDto;
import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.repositories.UserRepository;

import static hkeller.escolacaesguia.mapper.UsuarioMapper.mapToUsuarioDto;

@Service
public class ObterTutorServico {
    @Autowired
    UserRepository usuarioRepositorio;

    public UsuarioDto execute(Long idTutor) {
        User tutor = usuarioRepositorio.findById(idTutor).get();

        return mapToUsuarioDto(tutor);
    }
}
