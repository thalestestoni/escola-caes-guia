package hkeller.escolacaesguia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.dtos.LoginDto;
import hkeller.escolacaesguia.repositories.UserRepository;

@Service
public class LoginService {
    
    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public boolean login(LoginDto login) {
        // if (!userRepository.existsByEmail(login.getEmail())) {
        //     return false;
        // }
        
        // var user = userRepository.findByEmail(login.getEmail());

        // if (passwordEncoder().encode(login.getPassword()) != user.getPassword()) {
        //     return false;
        // }
        
        return true;
    }
}
