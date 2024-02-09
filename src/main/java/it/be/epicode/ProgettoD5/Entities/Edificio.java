package it.be.epicode.ProgettoD5.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String nome;
    private String indirizzo;

    private String citta;
    @OneToMany
    private List<Postazione> postaziones;

    public Edificio(String nome, String indirizzo, String citta, List<Postazione> postaziones) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.postaziones = postaziones;
    }
}
