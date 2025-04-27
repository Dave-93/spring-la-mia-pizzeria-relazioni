package it.lessons.spring.spring_la_mia_pizzeria_relazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.lessons.spring.spring_la_mia_pizzeria_relazioni.model.Ingredienti;

public interface IngredientiRepository extends JpaRepository<Ingredienti, Integer>{

}
