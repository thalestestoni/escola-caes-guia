package hkeller.escolacaesguia.socializador.controller;

import hkeller.escolacaesguia.common.interfaces.IInsertPersistencePort;
import hkeller.escolacaesguia.socializador.model.Socializador;
import hkeller.escolacaesguia.socializador.services.SocializadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/socializador")
public class SocializadorController {

  @Autowired
  private IInsertPersistencePort<Socializador> insertPersistencePort;



}
