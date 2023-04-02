package hkeller.escolacaesguia.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hkeller.escolacaesguia.dtos.CreateUserDto;
import hkeller.escolacaesguia.dtos.CreateUserRoleDto;
import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.services.CreateUserRoleService;
import hkeller.escolacaesguia.services.CreateUserService;
import hkeller.escolacaesguia.services.GetAllUsersService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    CreateUserService createUserService;

    @Autowired
    CreateUserRoleService createUserRoleService;

    @Autowired
    GetAllUsersService getAllUsersService;

    @PostMapping
    public User create(@RequestBody @Valid CreateUserDto createUserDto) {
        var user = new User();
        BeanUtils.copyProperties(createUserDto, user);
        
        return createUserService.execute(user);
    }

    @GetMapping
    public List<User> get() {
        return getAllUsersService.execute();
    }

    @PostMapping("/{userId}/roles")
    public User role(@RequestBody CreateUserRoleDto createUserRoleDto) {
        return createUserRoleService.execute(createUserRoleDto);
    }
}