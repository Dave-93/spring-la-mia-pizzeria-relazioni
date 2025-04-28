package it.lessons.spring.spring_la_mia_pizzeria_relazioni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.lessons.spring.spring_la_mia_pizzeria_relazioni.model.Ingredienti;
import it.lessons.spring.spring_la_mia_pizzeria_relazioni.model.Pizza;
import it.lessons.spring.spring_la_mia_pizzeria_relazioni.repository.IngredientiRepository;

@Service
public class IngredientiService {

    @Autowired
    private IngredientiRepository ingredientiRepository;

    public List<Ingredienti> findAllCategories(){
        return ingredientiRepository.findAll();
    }

    public Ingredienti create(Ingredienti ing){
        return ingredientiRepository.save(ing);
    }

    public void deleteById(int id){
        Ingredienti ing = ingredientiRepository.findById(id).get();
        for(Pizza p : ing.getPizza()){
            p.getIngredienti().remove(ing);
        }
        ingredientiRepository.deleteById(id);
    }

}