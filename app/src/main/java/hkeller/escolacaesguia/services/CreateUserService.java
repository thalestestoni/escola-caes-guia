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
    public User execute(User userModel) {
        return userRepository.save(userModel);
    }
}
