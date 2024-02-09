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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String nome;
    private String indirizzo;

    private String citta;
    @OneToMany
    @JoinColumn(name = "postazioni")
    private List<Postazione> postaziones;

    public Edificio(String nome, String indirizzo, String citta, List<Postazione> postaziones) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.postaziones = postaziones;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Postazione> getPostaziones() {
        return postaziones;
    }

    public void setPostaziones(List<Postazione> postaziones) {
        this.postaziones = postaziones;
    }
}
