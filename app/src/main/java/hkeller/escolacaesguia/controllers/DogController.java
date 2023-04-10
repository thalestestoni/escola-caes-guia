package hkeller.escolacaesguia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dogs")
public class DogController {
    @GetMapping("registration")
    public String create() {
        return "dog-registration";
    }
}
