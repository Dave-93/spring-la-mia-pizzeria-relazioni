package it.lessons.spring.spring_la_mia_pizzeria_relazioni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.lessons.spring.spring_la_mia_pizzeria_relazioni.model.Ingredienti;
import it.lessons.spring.spring_la_mia_pizzeria_relazioni.service.IngredientiService;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/ingredienti")
public class IngredientiController {

    @Autowired
    private IngredientiService service;
    
    /*Creazione Ingredienti*/
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("list", service.findAllCategories());
        model.addAttribute("ingredientiObj", new Ingredienti());
        return "ingredienti/index";
    }
    @PostMapping("/create")
    public String aggiunta(@Valid @ModelAttribute("ingredientiObj") Ingredienti ingredienti, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()){
            service.create(ingredienti);
        }
        return "redirect:/ingredienti";
    }
    /* */

    /*Cancellazione*/
    @PostMapping("/delete/{id}")
    public String cancellazione(@PathVariable int id, Model model){
        service.deleteById(id);
        return "redirect:/ingredienti";
    }
    /* */
}