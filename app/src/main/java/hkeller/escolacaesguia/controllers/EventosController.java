package hkeller.escolacaesguia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hkeller.escolacaesguia.dtos.CaoDto;
import hkeller.escolacaesguia.dtos.RequisicaoCadastroEventoDto;
import hkeller.escolacaesguia.services.CadastrarEventoServico;
import hkeller.escolacaesguia.services.ObterCaoServico;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/caes/{idCao}/eventos")
public class EventosController {
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
    public String eventos(@PathVariable("idCao") Long idCao, Model model) {
        CaoDto caoDto = obterCaoServico.execute(idCao);

        model.addAttribute("cao", caoDto);

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
