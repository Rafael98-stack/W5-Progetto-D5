package it.be.epicode.ProgettoD5.DAO;

import it.be.epicode.ProgettoD5.Entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {
}