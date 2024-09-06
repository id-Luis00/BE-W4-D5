package com.edi_Luis.repositories;

import com.edi_Luis.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

    @Query("SELECT COUNT(p) > 0 FROM Prenotazione p WHERE p.dataPrenotazione = :dataPrenotazione AND p.utente.id = :idUtente")
    boolean checkIfAlreadyBooked(@Param("dataPrenotazione") LocalDate dataPrenotazione, @Param("idUtente") UUID idUtente);


}
