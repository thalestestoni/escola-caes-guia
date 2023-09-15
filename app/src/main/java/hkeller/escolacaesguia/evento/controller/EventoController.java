package hkeller.escolacaesguia.evento.controller;

import hkeller.escolacaesguia.cao.dto.CaoDto;
import hkeller.escolacaesguia.cao.services.ObterCaoServico;
import hkeller.escolacaesguia.evento.dto.RequisicaoCadastroEventoDto;
import hkeller.escolacaesguia.evento.services.CadastrarEventoServico;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/caes/{idCao}/eventos")
public class EventoController {
    @Autowired
    ObterCaoServico obterCaoServico;

    @Autowired
    CadastrarEventoServico cadastrarEventoServico;

    @GetMapping("cadastro")
    public String obterFormularioCadastro(@PathVariable Long idCao, Model model) {
        RequisicaoCadastroEventoDto requisicaoCadastroEvento = new RequisicaoCadastroEventoDto(idCao);

        model.addAttribute("evento", requisicaoCadastroEvento);

        return "evento/cadastro";
    }

    @GetMapping()
    public String eventos(@PathVariable("idCao") Long idCao, HttpServletRequest request, Model model) {
        CaoDto caoDto = obterCaoServico.execute(idCao);

        model.addAttribute("cao", caoDto);

        String baseUrl = ServletUriComponentsBuilder
            .fromRequestUri(request)
            .replacePath(null)
            .build()
            .toUriString();

        model.addAttribute("baseUrl", baseUrl);

        return "evento/listagem";
    }

    @PostMapping()
    public String post(
        @PathVariable("idCao") Long idCao,
        @Valid @ModelAttribute("evento") RequisicaoCadastroEventoDto evento,
        BindingResult result,
        Model model)
    {
        if (result.hasErrors()) {
            model.addAttribute("evento", evento);
            return "evento/cadastro";
        }

        CaoDto cao = obterCaoServico.execute(idCao);

        cadastrarEventoServico.execute(cao, evento);

        String redirect = "redirect:/caes/" + idCao + "/eventos";

        return redirect;
    }
}
