package hkeller.escolacaesguia.user.services;

import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
