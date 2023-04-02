package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class CreateUserService {
    
    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public User execute(User user) {
        User existsUser = userRepository.findByEmail(user.getEmail());

        if (existsUser != null) {
            throw new Error("Usuário já existe!");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));

        User createdUser = userRepository.save(user);

        return createdUser;
    }
}
