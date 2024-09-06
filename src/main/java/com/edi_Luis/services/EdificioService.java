package com.edi_Luis.services;

import com.edi_Luis.entities.Edificio;
import com.edi_Luis.exceptions.NotFoundException;
import com.edi_Luis.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;


    public void salvaEdificio(Edificio edificio) {
        edificioRepository.save(edificio);
        log.info("Edificio salvato, con id: {}", edificio.getId());
    }

    public Edificio findById(UUID id) {
        return edificioRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Edificio non trovato"));
    }

}
