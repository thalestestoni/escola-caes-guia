package hkeller.escolacaesguia.user.services;

import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsersService {
    @Autowired
    UserRepository userRepository;

    public List<User> execute() {
        return userRepository.findAll();
    }
}
