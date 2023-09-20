package hkeller.escolacaesguia.user.controller;

import hkeller.escolacaesguia.common.excptionhandler.exception.SenhaIncorretaError;
import hkeller.escolacaesguia.common.security.SecurityUtil;
import hkeller.escolacaesguia.user.dtos.AlteracaoSenhaDto;
import hkeller.escolacaesguia.user.dtos.CreateUserDto;
import hkeller.escolacaesguia.user.dtos.UsuarioDto;
import hkeller.escolacaesguia.user.models.User;
import hkeller.escolacaesguia.user.services.*;
import hkeller.escolacaesguia.user.validators.AlteracaoSenhaUsuarioValidator;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    AlterarSenhaUsuarioServico alterarSenhaUsuarioServico;

    @PostMapping
    public User create(@RequestBody @Valid CreateUserDto createUserDto) {
        var user = new User();
        BeanUtils.copyProperties(createUserDto, user);

        return createUserService.execute(user);
    }

    @GetMapping("perfil")
    public String perfil(Model model) {
        String emailUsuarioLogado = SecurityUtil.obterEmailUsuarioLogado();

        UsuarioDto usuarioDto = obterUsuarioPorEmailServico.execute(emailUsuarioLogado);

        model.addAttribute("usuario", usuarioDto);

        return "perfil";
    }

    @GetMapping("alterar-senha")
    public String alterarSenha(Model model) {
        AlteracaoSenhaDto alteracaoSenhaDto = new AlteracaoSenhaDto();

        model.addAttribute("senha", alteracaoSenhaDto);

        return "alterar-senha";
    }

    @PostMapping("alterar-senha")
    public String alterarSenha(
        @Valid @ModelAttribute("senha") AlteracaoSenhaDto alteracaoSenhaDto,
        BindingResult result,
        Model model)
    {
        AlteracaoSenhaUsuarioValidator validator = new AlteracaoSenhaUsuarioValidator();
        validator.validate(alteracaoSenhaDto, result);

        if (result.hasErrors()) {
            model.addAttribute("senha", alteracaoSenhaDto);

            return "alterar-senha";
        }

        String emailUsuarioLogado = SecurityUtil.obterEmailUsuarioLogado();

        try {
            alterarSenhaUsuarioServico.execute(emailUsuarioLogado, alteracaoSenhaDto);
        } catch(SenhaIncorretaError err) {
            FieldError fieldError = new FieldError(
                "senha",
                "senhaAtual",
                "Senha incorreta");

            result.addError(fieldError);

            return "alterar-senha";
        }


        return "redirect:/users/perfil";
    }
}
