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
        List<Postazione> postazioni = new ArrayList<>();
        List<Prenotazione> prenotazioni = new ArrayList<>();
        System.out.println("--------------------------------------------- SALVATAGGIO EDIFICIO -----------------------------------------");

        Edificio edificio1 = new Edificio("Maxim","Via della Giumenta","Roma",postazioni);
salvataggiService.saveEdificio(edificio1);

        System.out.println("--------------------------------------------- SALVATAGGIO POSTAZIONE -----------------------------------------");

        Postazione postazione1 = new Postazione(123213,"blabla", TIPO.PRIVATO, STATO.LIBERO,60,edificio1,prenotazioni);
postazioni.add(postazione1);
salvataggiService.savePostazione(postazione1);

        System.out.println("--------------------------------------------- SALVATAGGIO UTENTI -----------------------------------------");

        User user1 = new User("Marco","Orosio","","",postazioni);
        prenotazioni.add(user1);
prenotazioni.add(user1);

salvataggiService.savePrenotazione(user1);

    }
}

