package it.lessons.spring.spring_la_mia_pizzeria_relazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.lessons.spring.spring_la_mia_pizzeria_relazioni.model.Offerta;

public interface OffertaRepository extends JpaRepository<Offerta, Integer>{

}
