package it.be.epicode.ProgettoD5.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.persister.entity.SingleTableEntityPersister;

import java.util.List;
import java.util.Random;

@Entity
@Data
public abstract class Prenotazione {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
private String username;

private String usersurname;
private String nomeCompleto;

private String email;

@ManyToMany
private List<Postazione> postaziones;

    public Prenotazione() {
    }

    public Prenotazione(String username, String usersurname, String nomeCompleto, String email, List<Postazione> postaziones) {
        this.username = username;
        this.usersurname = usersurname;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.postaziones = postaziones;
    }

    public void nomeCompleto() {
        this.nomeCompleto = this.username + " " + this.usersurname;
    }

    public String email() {
        Random random = new Random();
int randomPick = random.nextInt(RANDOMSITE.values().length);
;
      return   this.nomeCompleto.toLowerCase() + RANDOMSITE.values()[randomPick].toString();
    }
}
