package hkeller.escolacaesguia.atualizarCao.controller;


import hkeller.escolacaesguia.atualizarCao.dto.AtualizarCaoDto;
import hkeller.escolacaesguia.atualizarCao.dto.RequisicaoCadastroAtualizarCaoDto;
import hkeller.escolacaesguia.atualizarCao.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/atualizarCaes")
public class AtualizarCaoController {
    @Autowired
    CadastrarAtualizacaoCaoServico atualizarCaoServico;

    @Autowired
    ObterListaAtualizacoesCaesServico obterListaAtualizacoesCaesServico;

    @Autowired
    DeletarAtualizacaoCaoServico deletarAtualizacaoCaoServico;

    @Autowired
    ObterAtualizacaoCaoServico obterAtualizacaoCaoServico;

    @GetMapping("cadastro")
    public String getFormularioCadastro(Model model) {
        RequisicaoCadastroAtualizarCaoDto atualizacaoCao = new RequisicaoCadastroAtualizarCaoDto();

        model.addAttribute("atualizarCao", atualizacaoCao);

        return "atualizarCao/cadastro";
    }

    @PostMapping()
    public String post(@Valid @ModelAttribute("atualizarCao") RequisicaoCadastroAtualizarCaoDto atualizacaoCao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("atualizarCao", atualizacaoCao);

            return "atualizarCao/cadastro";
        }

      atualizarCaoServico.executar(atualizacaoCao);

        return "redirect:/atualizarCaes";
    }

    @GetMapping()
    public String get(HttpServletRequest request, Model model) {
        String baseUrl = ServletUriComponentsBuilder
            .fromRequestUri(request)
            .replacePath(null)
            .build()
            .toUriString();

        model.addAttribute("baseUrl", baseUrl);

        return "atualizarCao/listagem";
    }

    @GetMapping("{idAtualizacaoCao}/deletar")
    public String delete(@PathVariable("idAtualizacaoCao") Long id) {
      deletarAtualizacaoCaoServico.execute(id);

        return "redirect:/atualizarCaes";
    }

    @GetMapping("{idAtualizacaoCao}/visualizar")
    public String visualizar(@PathVariable("idAtualizacaoCao") Long idAtualizacaoCao, Model model) {
        AtualizarCaoDto atualizarCaoDto = obterAtualizacaoCaoServico.execute(idAtualizacaoCao);

        model.addAttribute("atualizarCao", atualizarCaoDto);

        return "atualizarCao/visualizar";
    }
}
