package it.be.epicode.ProgettoD5.Entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
public class User extends Prenotazione{

    public User(String username, String usersurname, String nomeCompleto, String email, List<Postazione> postaziones) {
        super(username, usersurname, nomeCompleto, email, postaziones);
    }

}
