package com.edi_Luis.services;

import com.edi_Luis.entities.Edificio;
import com.edi_Luis.entities.Postazione;
import com.edi_Luis.exceptions.NotFoundException;
import com.edi_Luis.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private EdificioService edificioService;

    public void savePostazione(Postazione postazione, UUID idEdificio) {

        // se l'edificio è salvato sul db, allora puoi salvare la postazione
        Edificio edificioTrovato = edificioService.findById(idEdificio);
        if (edificioTrovato != null) {
            postazione.setEdificio(edificioTrovato);
            postazioneRepository.save(postazione);
            log.info("Postazione salvata con successo!" +
                    "\nL'id della postazione è: " + postazione.getId());
        } else {
            throw new NotFoundException("Edificio non trovato!");
        }

    }

    public List<Postazione> findAllPostazioni() {
        return postazioneRepository.findAll();
    }

    public Postazione findById(UUID id) {
        return postazioneRepository.findById(id).orElseThrow(() -> new NotFoundException("Postazione non trovata!!!\n"));
    }


}
