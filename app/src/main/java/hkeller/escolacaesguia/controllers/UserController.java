package hkeller.escolacaesguia.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hkeller.escolacaesguia.dtos.CreateUserDto;
import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.services.CreateUserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    final CreateUserService createUserService;

    public UserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping
    public void create(@RequestBody @Valid CreateUserDto createUserDto) {
        var userModel = new User();
        BeanUtils.copyProperties(createUserDto, userModel);
        createUserService.execute(userModel);
    }
}