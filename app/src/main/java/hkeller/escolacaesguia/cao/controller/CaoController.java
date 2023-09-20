package hkeller.escolacaesguia.cao.controller;

import hkeller.escolacaesguia.cao.dto.CaoDto;
import hkeller.escolacaesguia.cao.dto.RequisicaoCadastroCaoDto;
import hkeller.escolacaesguia.cao.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Controller
@RequestMapping("/caes")
public class CaoController {
    @Autowired
    CadastrarCaoServico cadastrarCaoServico;

    @Autowired
    ObterListaCaesServico obterListaCaesServico;

    @Autowired
    DeletarCaoServico deletarCaoServico;

    @Autowired
    ObterCaoServico obterCaoServico;

    @Autowired
    EditarCaoServico editarCaoServico;

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

    @GetMapping("{idCao}/deletar")
    public String delete(@PathVariable("idCao") Long id) {
        deletarCaoServico.execute(id);

        return "redirect:/caes";
    }

    @GetMapping("{idCao}/editar")
    public String formEditar(@PathVariable("idCao") Long idCao, Model model) {
        CaoDto caoDto = obterCaoServico.execute(idCao);

        model.addAttribute("cao", caoDto);

        return "cao/editar";
    }

    @PostMapping("{idCao}/editar")
    public String editar(@PathVariable("idCao") Long idCao, @ModelAttribute("cao") CaoDto caoDto) {
        caoDto.setId(idCao);

        editarCaoServico.execute(caoDto);

        return "redirect:/caes";
    }

    @GetMapping("{idCao}/visualizar")
    public String visualizar(@PathVariable("idCao") Long idCao, Model model) {
        CaoDto caoDto = obterCaoServico.execute(idCao);

        model.addAttribute("cao", caoDto);

        return "cao/visualizar";
    }
}
