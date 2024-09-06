package com.edi_Luis.services;

import com.edi_Luis.entities.Postazione;
import com.edi_Luis.entities.Prenotazione;
import com.edi_Luis.entities.Utente;
import com.edi_Luis.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

@Service
@Slf4j
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

    Scanner scanner = new Scanner(System.in);


    public void saveNewPrenotazione(UUID idUtente, UUID idPostazione, LocalDate dataPrenotazione) {

        Utente utenteFound = utenteService.findById(idUtente);
        Postazione postazioneFound = postazioneService.findById(idPostazione);


        if (!prenotazioneRepository.checkIfAlreadyBooked(dataPrenotazione, idUtente)) {
            Prenotazione prenotazione = new Prenotazione(dataPrenotazione, postazioneFound, utenteFound);
            prenotazioneRepository.save(prenotazione);
            log.info("Prenotazione effettutata con successo!\n id della prenotazione: {}", prenotazione.getId());
        } else {
            throw new RuntimeException("Hai già prenotato per quella data! ");
        }

    }


}
