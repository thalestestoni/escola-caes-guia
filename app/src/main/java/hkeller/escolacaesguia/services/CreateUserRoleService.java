package hkeller.escolacaesguia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkeller.escolacaesguia.dtos.CreateUserRoleDto;
import hkeller.escolacaesguia.models.Role;
import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.repositories.UserRepository;

@Service
public class CreateUserRoleService {
    @Autowired
    UserRepository userRepository;

    public User execute(CreateUserRoleDto createUserRoleDto) {
        Optional<User> userExists = userRepository.findById(createUserRoleDto.getUserId());
        List<Role> roles = new ArrayList<>();

        if (userExists.isEmpty()) {
            throw new Error("Usuário não existe!");
        }

        roles = createUserRoleDto.getRoleIds().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());

        User user = userExists.get();

        // user.setRoles
        
        userRepository.save(user);

        return user;
    }
}
