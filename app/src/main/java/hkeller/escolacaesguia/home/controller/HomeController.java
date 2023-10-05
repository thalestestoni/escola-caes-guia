package hkeller.escolacaesguia.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hkeller.escolacaesguia.common.enums.EstadoCivilEnum;
import hkeller.escolacaesguia.common.enums.GrauInstrucaoEnum;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("grausInstrucao", GrauInstrucaoEnum.values());
        model.addAttribute("estadosCivis", EstadoCivilEnum.values());
        return "home";
    }
}
