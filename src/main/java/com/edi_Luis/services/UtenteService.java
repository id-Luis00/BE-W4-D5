package com.edi_Luis.services;


import com.edi_Luis.entities.Utente;
import com.edi_Luis.exceptions.NotFoundException;
import com.edi_Luis.exceptions.ValidationException;
import com.edi_Luis.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public void saveUtente(Utente utente) {

        // utente già registrato?
        // controllo dell'email
        // controllo username
        if (utenteRepository.existsByUsername(utente.getUsername()))
            throw new ValidationException("L'utente " + utente.getUsername() + " è già presente!");
        utenteRepository.save(utente);
        log.info("Utente: " + utente.getUsername() + " è stato registrato con successo!");

    }

    public Utente findById(UUID id) {
        Utente utenteTrovato = utenteRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("L'utente con id: " + id + " non è stato trovato"));
        return utenteTrovato;
    }
}
