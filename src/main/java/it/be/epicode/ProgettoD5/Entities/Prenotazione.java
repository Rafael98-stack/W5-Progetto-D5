package it.be.epicode.ProgettoD5.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.persister.entity.SingleTableEntityPersister;

import java.util.List;
import java.util.Random;

@Entity
@Data
public abstract class Prenotazione {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
private String username;

private String usersurname;
private String nomeCompleto;

private String email;

@ManyToMany
@JoinTable( name = "postazioni_prenotazioni",
        joinColumns = @JoinColumn(name = "prenotazioni_id"),
        inverseJoinColumns = @JoinColumn(name = "postazioni_id"))
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersurname() {
        return usersurname;
    }

    public void setUsersurname(String usersurname) {
        this.usersurname = usersurname;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Postazione> getPostaziones() {
        return postaziones;
    }

    public void setPostaziones(List<Postazione> postaziones) {
        this.postaziones = postaziones;
    }

}
