package com.edi_Luis.entities;


import com.edi_Luis.enums.TypePostazione;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@Entity
public class Postazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String description;
    @Enumerated(EnumType.STRING)
    private TypePostazione typePostazione;
    private String max_sits;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    public Postazione(String description, TypePostazione typePostazione, String max_sits, Edificio edificio) {
        this.description = description;
        this.typePostazione = typePostazione;
        this.max_sits = max_sits;
        this.edificio = edificio;
    }

    public Postazione(String description, TypePostazione typePostazione, String max_sits, Edificio edificio, List<Prenotazione> prenotazioni) {
        this.description = description;
        this.typePostazione = typePostazione;
        this.max_sits = max_sits;
        this.edificio = edificio;
        this.prenotazioni = prenotazioni;
    }
}
