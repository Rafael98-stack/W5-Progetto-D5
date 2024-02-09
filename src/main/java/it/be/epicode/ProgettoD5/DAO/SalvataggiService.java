package it.be.epicode.ProgettoD5.DAO;

import it.be.epicode.ProgettoD5.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

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

  public static final String privato = TIPO.PRIVATO.toString();
   public static final String salaRiunioni = TIPO.SALA_RIUNIONI.toString();
   public static final String openSpace= TIPO.OPEN_SPACE.toString();

    //////////////////////////////////////////////////////
    public void savePrenotazione(Prenotazione p) {
        p.setNomeCompleto(p.getUsername() + " " + p.getUsersurname()) ;
 if (Objects.equals(p.getUsername(), "") || Objects.equals(p.getUsersurname(), "")) {
     throw new RuntimeException("ATTENZIONE il Nome o Cognome non sono stati Impostati");

 } else if (Objects.equals(p.getEmail(), "")) {
            System.out.println("Nessuna email inserita per: " + p.getNomeCompleto());
            p.setEmail(p.getUsername().toLowerCase() + p.getUsersurname().toLowerCase() + "@" + RANDOMSITE.values()[randomPick].toString() + ".com");
            System.out.println("E-mail provvisoria generata: " + p.getEmail());
        }

 prenotazioniDAO.save(p);
        System.out.println("USER" + " " + p.getNomeCompleto() + " Salvato");
    }

    public void savePostazione(Postazione p) {
     if (Objects.equals(p.getTipo(), TIPO.PRIVATO.toString())) {
         p.setNumeroOccupantiMassimo(5);
     } else if (Objects.equals(p.getTipo(), TIPO.OPEN_SPACE.toString())) {
         p.setNumeroOccupantiMassimo(50);
     } else {
         p.setNumeroOccupantiMassimo(random.nextInt(10,20));
        }
        postazioneDAO.save(p);
        System.out.println("Codice Univoco: " + p.getCodiceUnivoco() + " Postazione Salvata");
    }

    public void saveEdificio(Edificio e) {
     edificioDAO.save(e);
        System.out.println("Edificio: " + e.getNome() + " Salvato");
    }
}
