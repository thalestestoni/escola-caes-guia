package hkeller.escolacaesguia.endereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hkeller.escolacaesguia.endereco.dtos.EnderecoDto;
import hkeller.escolacaesguia.endereco.services.BuscarEnderecoPorCepService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
  @Autowired
  private BuscarEnderecoPorCepService buscarEnderecoPorCepService;

  @GetMapping()
  public EnderecoDto get(@RequestParam("cep") int cep) {
    EnderecoDto endereco = buscarEnderecoPorCepService.execute(cep);

    return endereco;
  }
}
