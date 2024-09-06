package com.edi_Luis.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@Entity
public class Utente {
    
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String username;
    private String full_name;
    private String email;


    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    public Utente(String username, String full_name, String email) {
        this.username = username;
        this.full_name = full_name;
        this.email = email;
    }

    public Utente(String username, String full_name, String email, List<Prenotazione> prenotazioni) {
        this.username = username;
        this.full_name = full_name;
        this.email = email;
        this.prenotazioni = prenotazioni;
    }
}
