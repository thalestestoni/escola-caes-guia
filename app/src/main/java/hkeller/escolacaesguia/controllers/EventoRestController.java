package hkeller.escolacaesguia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hkeller.escolacaesguia.models.Evento;
import hkeller.escolacaesguia.services.ObterEventosCaoServico;

@RestController
@RequestMapping("rest/caes/{idCao}/eventos")
public class EventoRestController {
    @Autowired
    ObterEventosCaoServico obterEventosCaoServico;

    @GetMapping()
    public Page<Evento> get(@PathVariable Long idCao, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return obterEventosCaoServico.execute(idCao, page, size);
        //TODO: Retornar um Page de EventoDto
    }
}
