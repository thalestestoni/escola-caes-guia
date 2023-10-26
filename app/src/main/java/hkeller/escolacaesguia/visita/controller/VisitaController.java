package hkeller.escolacaesguia.visita.controller;

import hkeller.escolacaesguia.visita.dtos.RequisicaoCadastroVisitasDto;
import hkeller.escolacaesguia.visita.model.Visita;
import hkeller.escolacaesguia.visita.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/visitas")
public class VisitaController {

  private final VisitaService visitaService;


  @Autowired
  public VisitaController(VisitaService visitaService) {
    this.visitaService = visitaService;
  }

  @GetMapping()
  public String listVisitas(Model model) {
    List<Visita> visitas = visitaService.getAllVisitas();
    model.addAttribute("visitas", visitas);
    return "visita/listagem";
  }

  @GetMapping("/cadastro")
  public String cadastroVisita(Model model) {
    RequisicaoCadastroVisitasDto visitas = new RequisicaoCadastroVisitasDto();
    model.addAttribute("visitas", visitas);

    Visita visita = new Visita();
    model.addAttribute("visita", visita);
    return "visita/cadastro";
  }

  @PostMapping("/cadastro")
  public String saveVisita(@ModelAttribute("visita") Visita visita) {
    visitaService.save(visita);
    return "redirect:/visitas";
  }

  @GetMapping("{id}/editar")
  public String editarVisita(@PathVariable Long id, Model model) {
    Visita visita = visitaService.getVisitaById(id);
    model.addAttribute("visita", visita);
    return "visita/editar";
  }

  @GetMapping("{id}/visualizar")
  public String visualizarVisita(@PathVariable Long id, Model model) {
    Visita visita = visitaService.getVisitaById(id);
    model.addAttribute("visita", visita);
    return "visita/visualizar";
  }

}
