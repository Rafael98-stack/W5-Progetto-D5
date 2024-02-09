package it.be.epicode.ProgettoD5.Entities;

import jakarta.persistence.*;
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
}
