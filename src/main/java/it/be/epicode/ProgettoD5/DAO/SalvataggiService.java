package it.be.epicode.ProgettoD5.DAO;

import it.be.epicode.ProgettoD5.Entities.Edificio;
import it.be.epicode.ProgettoD5.Entities.Postazione;
import it.be.epicode.ProgettoD5.Entities.Prenotazione;
import it.be.epicode.ProgettoD5.Entities.RANDOMSITE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
public class SalvataggiService {
    @Autowired
    private EdificioDAO edificioDAO;
    @Autowired
    private PostazioneDAO postazioneDAO;
    @Autowired
    private PrenotazioniDAO prenotazioniDAO;
/////////////////////////// GLOBAL SCOPE ///////////////////////////

    Random random = new Random();
    int randomPick = random.nextInt(RANDOMSITE.values().length);

    //////////////////////////////////////////////////////
    public void savePrenotazione(Prenotazione p) {
 if (Objects.equals(p.getUsername(), "") || Objects.equals(p.getUsersurname(), "")) {
     throw new RuntimeException("ATTENZIONE il Nome o Cognome non sono stati Impostati");

 } else if (Objects.equals(p.getEmail(), "")) {
            System.out.println("Nessuna email inserita");
            p.setEmail(p.getUsername().toLowerCase() + p.getUsersurname().toLowerCase() + "@" + RANDOMSITE.values()[randomPick].toString() + ".com");
            System.out.println("E-mail provvisoria generata: " + p.getEmail());
        }

         p.setNomeCompleto(p.getUsername() + " " + p.getUsersurname()) ;

        prenotazioniDAO.save(p);
        System.out.println("USER" + " " + p.getNomeCompleto() + " Salvato");
    }

    public void savePostazione(Postazione p) {
       postazioneDAO.save(p);
    }

    public void saveEdificio(Edificio e) {
     edificioDAO.save(e);
    }
}
