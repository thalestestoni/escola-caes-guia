package hkeller.escolacaesguia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkeller.escolacaesguia.dtos.RequisicaoCadastroCaoDto;
import hkeller.escolacaesguia.models.Cao;
import hkeller.escolacaesguia.services.CadastrarCaoServico;
import hkeller.escolacaesguia.services.ObterListaCaesServico;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/cao")
public class CaoController {
    @Autowired
    CadastrarCaoServico cadastrarCaoServico;

    @Autowired
    ObterListaCaesServico obterListaCaesServico;

    @GetMapping("cadastro")
    public String formularioCadastro(Model model) {
        RequisicaoCadastroCaoDto cao = new RequisicaoCadastroCaoDto();

        model.addAttribute("cao", cao);
        
        return "cao/cadastro";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid @ModelAttribute("cao") RequisicaoCadastroCaoDto cao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cao", cao);

            return "cao/cadastro";
        }

        cadastrarCaoServico.executar(cao);

        return "redirect:/cao/listagem";
    }
    
    @GetMapping("listagem")
    public String listagem() {
        return "cao/listagem";
    }
}
