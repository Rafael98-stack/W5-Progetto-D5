package it.be.epicode.ProgettoD5.DAO;

import it.be.epicode.ProgettoD5.Entities.Postazione;
import it.be.epicode.ProgettoD5.Entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioniDAO extends JpaRepository<Prenotazione, Long> {
}
