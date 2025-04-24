package it.lessons.spring.spring_la_mia_pizzeria_relazioni.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Offerta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "La data di inizio è obbligatoria")
    private LocalDate dataOfferta;

    @NotNull(message = "La data di scadenza è obbligatoria")
    private LocalDate dataFineOfferta;

    @NotBlank(message = "Il codice è obbligatorio")
    private String titolo;

    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataOfferta() {
        return dataOfferta;
    }
    public void setDataOfferta(LocalDate dataOfferta) {
        this.dataOfferta = dataOfferta;
    }

    public LocalDate getDataFineOfferta() {
        return dataFineOfferta;
    }
    public void setDataFineOfferta(LocalDate dataFineOfferta) {
        this.dataFineOfferta = dataFineOfferta;
    }
    
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Pizza getPizza() {
        return pizza;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }   
}