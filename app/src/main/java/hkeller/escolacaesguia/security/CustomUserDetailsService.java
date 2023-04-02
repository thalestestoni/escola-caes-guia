package hkeller.escolacaesguia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements  UserDetailsService {
    
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user != null) {
            UserDetails userDetails = new UserPrincipal(user);

            return userDetails;
        } else {
            throw new UsernameNotFoundException("Usuário ou senha inválido");
        }
    }
}
