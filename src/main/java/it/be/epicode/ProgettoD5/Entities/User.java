package it.be.epicode.ProgettoD5.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User extends Prenotazione{
    public User() {
    }

    public User(String username, String usersurname, String nomeCompleto, String email, List<Postazione> postaziones) {
        super(username, usersurname, nomeCompleto, email, postaziones);
    }

}
