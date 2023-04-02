package hkeller.escolacaesguia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.repositories.UserRepository;

@Service
public class GetAllUsersService {
    @Autowired
    UserRepository userRepository;

    public List<User> execute() {
        return userRepository.findAll();
    }
}
