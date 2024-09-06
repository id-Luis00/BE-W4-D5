package com.edi_Luis.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioneService {

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;


}
