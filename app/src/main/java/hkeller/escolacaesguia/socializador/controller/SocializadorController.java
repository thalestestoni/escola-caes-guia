package hkeller.escolacaesguia.socializador.controller;

import hkeller.escolacaesguia.socializador.dto.SocializadorDto;
import hkeller.escolacaesguia.socializador.services.SocializadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/socializador")
public class SocializadorController {

  @Autowired
  private SocializadorService socializadorService;

  @GetMapping("/cadastrar")
  public String cadastrar(Model model){
    SocializadorDto socializador = new SocializadorDto();
    model.addAttribute("socializador", socializador);
    return "socializador/cadastro";
  }

  @PostMapping("/salvar")
  public String salvar(SocializadorDto socializadorDto){
    socializadorService.insert(socializadorDto);
    return "redirect:/socializador/cadastrar";
  }

}
