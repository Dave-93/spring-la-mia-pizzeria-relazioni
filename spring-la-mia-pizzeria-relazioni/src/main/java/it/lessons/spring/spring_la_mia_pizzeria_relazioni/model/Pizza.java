package it.lessons.spring.spring_la_mia_pizzeria_relazioni.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizza") 
public class Pizza {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message="Nome obbligatorio")
    @Column(unique=true, nullable=false)
    private String nome;

    @Column(length=1000)
    private String descrizione;

    @NotNull(message = "Prezzo obbligatorio")
    @DecimalMin(value = "1", inclusive = true, message="Il prezzo deve essere almeno di 1€")
    private BigDecimal prezzo;

    private String foto;

    @OneToMany(mappedBy = "pizza")
    private List<Offerta>sconti;

    @ManyToMany()
    @JoinTable(
        name = "pizza_ingredienti",
        joinColumns = @JoinColumn(name = "pizza_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredienti_id")
    )
    private List<Ingredienti> ingredienti;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Offerta> getSconti() {
        return sconti;
    }
    public void setSconti(List<Offerta> sconti) {
        this.sconti = sconti;
    }

    public List<Ingredienti> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(List<Ingredienti> ingredienti) {
        this.ingredienti = ingredienti;
    }
}