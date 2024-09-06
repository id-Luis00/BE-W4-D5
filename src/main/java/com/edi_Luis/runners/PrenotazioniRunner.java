package com.edi_Luis.runners;


import com.edi_Luis.entities.Edificio;
import com.edi_Luis.entities.Postazione;
import com.edi_Luis.entities.Prenotazione;
import com.edi_Luis.entities.Utente;
import com.edi_Luis.services.EdificioService;
import com.edi_Luis.services.PostazioneService;
import com.edi_Luis.services.PrenotazioneService;
import com.edi_Luis.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Component
public class PrenotazioniRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    // prove utenti
    @Autowired
    private Utente utente1;
    @Autowired
    private Utente utente2;
    @Autowired
    private Utente utente3;

    // prove postazioni
    @Autowired
    private Postazione postazione1;
    @Autowired
    private Postazione postazione2;
    @Autowired
    private Postazione postazione3;

    // prove edifici
    @Autowired
    private Edificio edificio1;
    @Autowired
    private Edificio edificio2;
    @Autowired
    private Edificio edificio3;

    // prove prenotazione
    @Autowired
    private Prenotazione prenotazione1;


    @Override
    public void run(String... args) throws Exception {


        System.out.println("ciao " + utente1.getUsername());
        System.out.println("ciao " + utente2.getUsername());
        System.out.println("ciao " + utente3.getUsername());

        Utente utente = new Utente("mitchel.turner", "Tayna Gleason Sr.", "daje.roma@gmail.magica");

        // utenteService.saveUtente(utente1);
        // utenteService.saveUtente(utente2);
        // utenteService.saveUtente(utente3);
        // try {
        //     utenteService.saveUtente(utente);
        // } catch (ValidationException ex) {
        //     log.error(ex.getMessage());
        // }

        // vuoi prenotare una postazione?
        // creare nuovo utente (ho già degli utenti) e salvo l'utente
        // inserire quale postazione vuoi prenotare

        // Utente utenteCercato = utenteService.findById(UUID.fromString("9d902-cadd-4505-a454-21ccb955b75e"));
        // System.out.println(utenteCercato.getFull_name() + " trovato con successo!");

        // edificioService.salvaEdificio(edificio1);
        // edificioService.salvaEdificio(edificio2);
        // edificioService.salvaEdificio(edificio3);

        //   postazioneService.savePostazione(postazione1, UUID.fromString("65bef401-5177-475c-92d4-5e60d3a19e41"));
        //   postazioneService.savePostazione(postazione2, UUID.fromString("65bef401-5177-475c-92d4-5e60d3a19e41"));

        prenotazioneService.saveNewPrenotazione(
                UUID.fromString("e6452124-2d61-4f36-a7f5-6c6997aba0ea"),
                UUID.fromString("8e699dd0-f9d7-4b66-80a3-143027953df7"),
                LocalDate.of(2024, 9, 7));
    }
}
