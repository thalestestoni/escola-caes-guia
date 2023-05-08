package hkeller.escolacaesguia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import hkeller.escolacaesguia.dtos.CadastroTutorDto;
import hkeller.escolacaesguia.services.CadastrarTutorServico;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("tutores")
public class TutorController {
    @Autowired
    CadastrarTutorServico cadastrarTutorServico;

    @GetMapping("cadastro")
    public String getFormularioCadastro(Model model) {
        CadastroTutorDto tutor = new CadastroTutorDto();

        model.addAttribute("tutor", tutor);
        
        return "tutor/cadastro";
    }

    @PostMapping()
    public String post(@Valid @ModelAttribute("tutor") CadastroTutorDto tutor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("tutor", tutor);

            return "tutor/cadastro";
        }

        cadastrarTutorServico.execute(tutor);

        return "redirect:/tutores";
    }

    @GetMapping()
    public String get() {
        return "tutor/listagem";
    }
}
