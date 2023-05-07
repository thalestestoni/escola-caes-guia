package hkeller.escolacaesguia.controllers;

import org.springframework.web.bind.annotation.RestController;

import hkeller.escolacaesguia.models.Cao;
import hkeller.escolacaesguia.services.ObterListaCaesServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("rest/caes")
public class CaoRestController {
    @Autowired
    ObterListaCaesServico obterListaCaesServico;

    @GetMapping()
    public Page<Cao> get(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return obterListaCaesServico.execute(page, size);
        //TODO: Retornar um Page de CaoDto
    }
}
