package it.be.epicode.ProgettoD5.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private long codiceUnivoco;

    private String descrizione;


    private String tipo;


    private String stato;

private int numeroOccupantiMassimo;

@ManyToOne
@JoinColumn
private Edificio edificio;

@ManyToMany
@JoinTable( name = "postazioni_prenotazioni",
        joinColumns = @JoinColumn(name = "postazioni_id"),
        inverseJoinColumns = @JoinColumn(name = "prenotazioni_id"))
private List<Prenotazione>prenotaziones;

    public Postazione(String descrizione, Edificio edificio, List<Prenotazione> prenotaziones) {
        Random random = new Random();
        int randomPickTipo = random.nextInt(TIPO.values().length);
        int randomPickStato = random.nextInt(STATO.values().length);
        this.descrizione = descrizione;
        this.edificio = edificio;
        this.prenotaziones = prenotaziones;
        this.codiceUnivoco = random.nextLong(50000L,300000L);
        this.stato = STATO.values()[randomPickStato].toString();
        this.tipo = TIPO.values()[randomPickTipo].toString();
    }

    public Postazione(long codiceUnivoco, String descrizione, TIPO tipo, STATO stato, int numeroOccupantiMassimo, Edificio edificio, List<Prenotazione> prenotaziones) {
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.tipo = tipo.toString();
        this.stato = stato.toString();
        this.numeroOccupantiMassimo = numeroOccupantiMassimo;
        this.edificio = edificio;
        this.prenotaziones = prenotaziones;
    }

    public long getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(long codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public int getNumeroOccupantiMassimo() {
        return numeroOccupantiMassimo;
    }

    public void setNumeroOccupantiMassimo(int numeroOccupantiMassimo) {
        this.numeroOccupantiMassimo = numeroOccupantiMassimo;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public List<Prenotazione> getPrenotaziones() {
        return prenotaziones;
    }

    public void setPrenotaziones(List<Prenotazione> prenotaziones) {
        this.prenotaziones = prenotaziones;
    }
}
