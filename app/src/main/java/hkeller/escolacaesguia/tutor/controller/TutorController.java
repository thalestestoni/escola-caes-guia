package hkeller.escolacaesguia.tutor.controller;

import hkeller.escolacaesguia.tutor.dtos.CadastroTutorDto;
import hkeller.escolacaesguia.tutor.services.CadastrarTutorServico;
import hkeller.escolacaesguia.tutor.services.DeletarTutorServico;
import hkeller.escolacaesguia.tutor.services.EditarTutorServico;
import hkeller.escolacaesguia.tutor.services.ObterTutorServico;
import hkeller.escolacaesguia.user.dtos.UsuarioDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("tutores")
public class TutorController {
    @Autowired
    CadastrarTutorServico cadastrarTutorServico;

    @Autowired
    ObterTutorServico obterTutorServico;

    @Autowired
    EditarTutorServico editarTutorServico;

    @Autowired
    DeletarTutorServico deletarTutorServico;


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
    public String get(HttpServletRequest request, Model model) {
        String baseUrl = ServletUriComponentsBuilder
        .fromRequestUri(request)
        .replacePath(null)
        .build()
        .toUriString();

        model.addAttribute("baseUrl", baseUrl);

        return "tutor/listagem";
    }

    @GetMapping("{idTutor}/editar")
    public String formEditar(@PathVariable("idTutor") Long idTutor, Model model) {
        UsuarioDto tutorDto = obterTutorServico.execute(idTutor);

        model.addAttribute("tutor", tutorDto);

        return "tutor/editar";
    }

    @PostMapping("{idTutor}/editar")
    public String editar(@PathVariable("idTutor") Long idTutor, @ModelAttribute("tutor") UsuarioDto tutorDto) {
        tutorDto.setId(idTutor);

        editarTutorServico.execute(tutorDto);

        return "redirect:/tutores";
    }

    @GetMapping("{idTutor}/visualizar")
    public String visualizar(@PathVariable("idTutor") Long idTutor, Model model) {
        UsuarioDto tutorDto = obterTutorServico.execute(idTutor);

        model.addAttribute("tutor", tutorDto);

        return "tutor/visualizar";
    }

    @GetMapping("{idTutor}/deletar")
    public String delete(@PathVariable("idTutor") Long idTutor) {
        deletarTutorServico.execute(idTutor);

        return "redirect:/tutores";
    }
}
