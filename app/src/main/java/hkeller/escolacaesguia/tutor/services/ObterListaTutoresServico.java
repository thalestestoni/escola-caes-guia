package hkeller.escolacaesguia.tutor.services;

import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ObterListaTutoresServico {
    @Autowired
    UserRepository usuarioRepositorio;

    public Page<User> execute(Integer page, Integer size) {
        //TODO: Futuramente buscar na lista de relação tutor_cao
        //TODO: Futuramente, no cadastro de tutor selecionar o cao.

        Page<User> tutores = usuarioRepositorio.findAll(PageRequest.of(page, size));

        return tutores;
    }
}
