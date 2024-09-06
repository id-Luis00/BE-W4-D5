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

        // -------------- prova salvataggio utenti

        // System.out.println("ciao " + utente1.getUsername());
        // System.out.println("ciao " + utente2.getUsername());
        // System.out.println("ciao " + utente3.getUsername());

        // utenteService.saveUtente(utente1);
        // utenteService.saveUtente(utente2);
        // utenteService.saveUtente(utente3);

        // -------------- prova salvataggio edifici

        // edificioService.salvaEdificio(edificio1);
        // edificioService.salvaEdificio(edificio2);
        // edificioService.salvaEdificio(edificio3);

        // -------------- prova salvataggio postazioni

        // postazioneService.savePostazione(postazione1, UUID.fromString("66b73434-4464-4128-94fa-fc19dbc0c9fb"));
        // postazioneService.savePostazione(postazione2, UUID.fromString("c2ada86e-f831-4e85-b169-dbc9042fb2a4"));

        // -------------- prova salvataggio prenotazioni

        // prenotazioneService.saveNewPrenotazione(idUtente, idPostazione, dataPrenotazione);

        //try {

        //    prenotazioneService.saveNewPrenotazione(
        //            UUID.fromString("ce60c85a-7844-4911-8926-c161bae03446"),
        //            UUID.fromString("e571d169-4df0-439c-b082-18bccdb70618"),
        //            LocalDate.of(2024, 9, 7));
        //} catch (Exception ex) {
        //    log.info(ex.getMessage());
        //}

        // System.out.println(postazioneService.findByType(TypePostazione.OPEN_SPACE));
        // System.out.println(postazioneService.findByType(TypePostazione.PRIVATO));

        System.out.println(postazioneService.findByCity("Roma"));
    }
}
