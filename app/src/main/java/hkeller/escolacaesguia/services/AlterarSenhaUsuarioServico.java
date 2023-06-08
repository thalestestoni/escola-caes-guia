package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.dtos.AlteracaoSenhaDto;
import hkeller.escolacaesguia.errors.SenhaIncorretaError;
import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.repositories.UserRepository;

@Service
public class AlterarSenhaUsuarioServico {
    @Autowired
    UserRepository usuarioRepositorio;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void execute(String email, AlteracaoSenhaDto dto) {
        if (dto.getSenhaNova() != dto.getConfirmacaoSenhaNova()) {
            
        }

        User usuario = usuarioRepositorio.findByEmail(email);

        Boolean senhaAtualEstaCorreta = BCrypt.checkpw(dto.getSenhaAtual(), usuario.getPassword());

        if (!senhaAtualEstaCorreta) {
            throw new SenhaIncorretaError();
        }

        usuario.setPassword(passwordEncoder().encode(dto.getSenhaNova()));

        usuarioRepositorio.save(usuario);
    }
}
