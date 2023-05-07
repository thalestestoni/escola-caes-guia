package hkeller.escolacaesguia.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hkeller.escolacaesguia.dtos.CreateUserDto;
import hkeller.escolacaesguia.dtos.UsuarioDto;
import hkeller.escolacaesguia.models.User;
import hkeller.escolacaesguia.security.SecurityUtil;
import hkeller.escolacaesguia.services.CreateUserRoleService;
import hkeller.escolacaesguia.services.CreateUserService;
import hkeller.escolacaesguia.services.GetAllUsersService;
import hkeller.escolacaesguia.services.ObterUsuarioPorEmailServico;
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

    @Autowired
    ObterUsuarioPorEmailServico obterUsuarioPorEmailServico;

    @PostMapping
    public User create(@RequestBody @Valid CreateUserDto createUserDto) {
        var user = new User();
        BeanUtils.copyProperties(createUserDto, user);
        
        return createUserService.execute(user);
    }

    @GetMapping("perfil")
    public String perfil(Model model) {
        String emailUsuarioLogado = SecurityUtil.obterEmailUsuarioLogado();

        if (emailUsuarioLogado.isBlank()) {
            return "redirect:/login";
        }

        UsuarioDto usuarioDto = obterUsuarioPorEmailServico.execute(emailUsuarioLogado);

        model.addAttribute("usuario", usuarioDto);

        return "perfil";
    }
}