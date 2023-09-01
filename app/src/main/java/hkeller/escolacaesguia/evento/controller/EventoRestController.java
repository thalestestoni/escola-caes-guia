package hkeller.escolacaesguia.evento.controller;

import hkeller.escolacaesguia.evento.model.Evento;
import hkeller.escolacaesguia.evento.services.ObterEventosCaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
