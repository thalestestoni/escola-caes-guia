package hkeller.escolacaesguia.user.services;

import hkeller.escolacaesguia.user.dtos.CreateUserRoleDto;
import hkeller.escolacaesguia.user.models.Role;
import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
