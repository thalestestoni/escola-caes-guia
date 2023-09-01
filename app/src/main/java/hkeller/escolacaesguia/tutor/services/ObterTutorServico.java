package hkeller.escolacaesguia.tutor.services;

import hkeller.escolacaesguia.user.dtos.UsuarioDto;
import hkeller.escolacaesguia.user.mapper.UsuarioMapper;
import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObterTutorServico {
    @Autowired
    UserRepository usuarioRepositorio;

    public UsuarioDto execute(Long idTutor) {
        User tutor = usuarioRepositorio.findById(idTutor).get();

        return UsuarioMapper.mapToUsuarioDto(tutor);
    }
}
