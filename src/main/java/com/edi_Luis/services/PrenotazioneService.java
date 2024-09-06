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


    public void savePrenotazione() {
        // chi vuole prenotare?
        // inserisci l'id dell'utente che vuole prenotare
        System.out.println("Inserisci l'id utente che vuole prenotare: ");
        String idUtente = scanner.nextLine();
        Utente utenteTrovato = utenteService.findById(UUID.fromString(idUtente));

        // quale postazione vuole prenotare?
        // stampa di tutte le postazioni
        // List<Postazione> postazioniTrovate = postazioneService.findAllPostazioni();
        // postazioniTrovate.forEach(System.out::println);

        for (Postazione postazione : postazioneService.findAllPostazioni()) {
            System.out.println(postazione);
        }

        // inserisci la postazione che vuoi occupare
        System.out.println("Inserisci l'id della postazione scelta: ");
        String idPostazione = scanner.nextLine();
        Postazione postazioneScelta = postazioneService.findById(UUID.fromString(idPostazione));

        Prenotazione nuovaPrenotazione = new Prenotazione(LocalDate.of(
                LocalDate.now().getYear(),
                LocalDate.now().getMonthValue(),
                LocalDate.now().getDayOfMonth()),
                postazioneScelta,
                utenteTrovato);

        prenotazioneRepository.save(nuovaPrenotazione);

    }

}
