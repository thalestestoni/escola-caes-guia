package hkeller.escolacaesguia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hkeller.escolacaesguia.dtos.LoginDto;
import hkeller.escolacaesguia.services.LoginService;

@Controller
public class LoginController {

    final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
      model.addAttribute("login", new LoginDto());
      return "login";
    }
}
