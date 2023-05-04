package hkeller.escolacaesguia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hkeller.escolacaesguia.dtos.RequisicaoCadastroCaoDto;
import hkeller.escolacaesguia.services.CadastrarCaoServico;
import hkeller.escolacaesguia.services.DeletarCaoServico;
import hkeller.escolacaesguia.services.ObterListaCaesServico;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/caes")
public class CaoController {
    @Autowired
    CadastrarCaoServico cadastrarCaoServico;

    @Autowired
    ObterListaCaesServico obterListaCaesServico;

    @Autowired
    DeletarCaoServico deletarCaoServico;

    @GetMapping("cadastro")
    public String getFormularioCadastro(Model model) {
        RequisicaoCadastroCaoDto cao = new RequisicaoCadastroCaoDto();

        model.addAttribute("cao", cao);
        
        return "cao/cadastro";
    }

    @PostMapping()
    public String post(@Valid @ModelAttribute("cao") RequisicaoCadastroCaoDto cao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cao", cao);

            return "cao/cadastro";
        }

        cadastrarCaoServico.executar(cao);

        return "redirect:/caes";
    }
    
    @GetMapping()
    public String get(HttpServletRequest request, Model model) {
        String baseUrl = ServletUriComponentsBuilder
            .fromRequestUri(request)
            .replacePath(null)
            .build()
            .toUriString();

        model.addAttribute("baseUrl", baseUrl);

        return "cao/listagem";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        deletarCaoServico.execute(id);

        return "redirect:/caes";
    }
}
