package hkeller.escolacaesguia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import hkeller.escolacaesguia.models.Cao;
import hkeller.escolacaesguia.services.CadastrarCaoServico;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/cao")
public class CaoController {
    @Autowired
    CadastrarCaoServico cadastrarCaoServico;

    @GetMapping()
    public String formularioCadastro(Model model) {
        Cao cao = new Cao();
        model.addAttribute("cao", cao);
        return "cadastro-cao";
    }

    @PostMapping()
    public void cadastrar(@ModelAttribute("cao") Cao cao) {
        cadastrarCaoServico.executar(cao);
        // redirecionar para listagem de caes cadastrados
    }
    
}
