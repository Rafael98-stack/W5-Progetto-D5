package it.be.epicode.ProgettoD5;

import it.be.epicode.ProgettoD5.DAO.EdificioDAO;
import it.be.epicode.ProgettoD5.DAO.PostazioneDAO;
import it.be.epicode.ProgettoD5.DAO.PrenotazioniDAO;
import it.be.epicode.ProgettoD5.DAO.SalvataggiService;
import it.be.epicode.ProgettoD5.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        System.out.println("--------------------------------------------- SALVATAGGIO UTENTI -----------------------------------------");

        User user1 = new User("Marco","Callegari","","",);
user1.nomeCompleto();
user1.email();
    }
}
