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

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name = "id_postazione")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;


    public Prenotazione(LocalDate dataPrenotazione, Postazione postazione, Utente utente) {
        this.dataPrenotazione = dataPrenotazione;
        this.postazione = postazione;
        this.utente = utente;
    }
}
