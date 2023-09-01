package hkeller.escolacaesguia.user.services;

import java.util.List;

import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllUsersService {
    @Autowired
    UserRepository userRepository;

    public List<User> execute() {
        return userRepository.findAll();
    }
}
