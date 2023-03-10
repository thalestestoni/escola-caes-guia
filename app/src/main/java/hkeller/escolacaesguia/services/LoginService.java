package hkeller.escolacaesguia.services;

import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.dtos.LoginDto;
import hkeller.escolacaesguia.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LoginService {
    
    final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(LoginDto login) {
        if (!userRepository.existsByEmail(login.getEmail())) {
            return false;
        }
        
        var user = userRepository.findByEmail(login.getEmail());

        if (user.getPassword() != login.getPassword()) {
            return false;
        }
        
        return true;
    }
}
