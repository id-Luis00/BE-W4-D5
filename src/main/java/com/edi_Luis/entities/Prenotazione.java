package com.edi_Luis.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Data
@ToString
@NoArgsConstructor
@Entity
public class Prenotazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private LocalDate data_prenotazione;

    @ManyToOne
    @JoinColumn(name = "id_postazione")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;


    public Prenotazione(LocalDate data_prenotazione, Postazione postazione, Utente utente) {
        this.data_prenotazione = data_prenotazione;
        this.postazione = postazione;
        this.utente = utente;
    }
}
