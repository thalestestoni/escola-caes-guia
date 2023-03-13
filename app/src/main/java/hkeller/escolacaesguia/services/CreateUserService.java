package hkeller.escolacaesguia.services;

import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class CreateUserService {
    
    final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User execute(User user) {
        User existsUser = userRepository.findByEmail(user.getEmail());

        if (existsUser != null) {
            throw new Error("Usuário já existe!");
        }

        User createdUser = userRepository.save(user);

        return createdUser;
    }
}
