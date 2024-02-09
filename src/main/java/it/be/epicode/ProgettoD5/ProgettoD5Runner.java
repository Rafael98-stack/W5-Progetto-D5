package it.be.epicode.ProgettoD5;

import it.be.epicode.ProgettoD5.DAO.EdificioDAO;
import it.be.epicode.ProgettoD5.DAO.PostazioneDAO;
import it.be.epicode.ProgettoD5.DAO.PrenotazioniDAO;
import it.be.epicode.ProgettoD5.DAO.SalvataggiService;
import it.be.epicode.ProgettoD5.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProgettoD5Runner implements CommandLineRunner {
    @Autowired
    private EdificioDAO edificioDAO;
    @Autowired
    private PostazioneDAO postazioneDAO;
    @Autowired
    private PrenotazioniDAO prenotazioniDAO;
    @Autowired
    private SalvataggiService salvataggiService;

    @Override
    public void run(String... args) throws Exception {
        List<Postazione> postazioni1 = new ArrayList<>();
        List<Postazione> postazioni2 = new ArrayList<>();

        List<Prenotazione> prenotazioni1 = new ArrayList<>();
        System.out.println("--------------------------------------------- SALVATAGGIO EDIFICIO -----------------------------------------");

        Edificio edificio1 = new Edificio("Maxim","Via della Giumenta","Roma",postazioni1);
salvataggiService.saveEdificio(edificio1);

Edificio edificio2 = new Edificio("Teodorus","Via Cagliari","Cagliari",postazioni2);
        salvataggiService.saveEdificio(edificio2);

        System.out.println("--------------------------------------------- SALVATAGGIO POSTAZIONE -----------------------------------------");

        Postazione postazione1 = new Postazione(123213,"blabla", TIPO.PRIVATO, STATO.LIBERO,60,edificio1,prenotazioni1);
        postazioni1.add(postazione1);
salvataggiService.savePostazione(postazione1);

Postazione postazione2 = new Postazione("APERTI SOLO DI FEBBRAIO",edificio1,prenotazioni1);
postazioni1.add(postazione2);
salvataggiService.savePostazione(postazione2);

        System.out.println("--------------------------------------------- SALVATAGGIO UTENTI -----------------------------------------");

        User user1 = new User("Marco","Orosio","","",postazioni1);
        prenotazioni1.add(user1);
        salvataggiService.savePrenotazione(user1);


        User user2 = new User("Giulio","Giannizzeri","Giulio Giannizzeri","qwerty@gmail.com",postazioni2);
        salvataggiService.savePrenotazione(user2);

    }
}

