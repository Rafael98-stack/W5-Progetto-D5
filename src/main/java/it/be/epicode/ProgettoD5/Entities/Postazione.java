package it.be.epicode.ProgettoD5.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private long codiceUnivoco;

    private String descrizione;

@Enumerated
    private TIPO tipo;

@Enumerated
    private STATO stato;

private int numeroOccupantiMassimo;

@ManyToOne
private Edificio edificio;

@ManyToMany
    private List<Prenotazione>prenotaziones;

    public Postazione(long codiceUnivoco, String descrizione, TIPO tipo, STATO stato, int numeroOccupantiMassimo, Edificio edificio, List<Prenotazione> prenotaziones) {
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.stato = stato;
        this.numeroOccupantiMassimo = numeroOccupantiMassimo;
        this.edificio = edificio;
        this.prenotaziones = prenotaziones;
    }
}
