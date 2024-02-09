package it.be.epicode.ProgettoD5.DAO;

import it.be.epicode.ProgettoD5.Entities.Edificio;
import it.be.epicode.ProgettoD5.Entities.Postazione;
import it.be.epicode.ProgettoD5.Entities.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvataggiService {
    @Autowired
    private EdificioDAO edificioDAO;
    @Autowired
    private PostazioneDAO postazioneDAO;
    @Autowired
    private PrenotazioniDAO prenotazioniDAO;

    public void savePrenotazione(Prenotazione p) {
        prenotazioniDAO.save(p);
    }

    public void savePostazione(Postazione p) {
       postazioneDAO.save(p);
    }

    public void saveEdificio(Edificio e) {
     edificioDAO.save(e);
    }
}
