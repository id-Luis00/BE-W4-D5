package com.edi_Luis.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Data
@ToString
@NoArgsConstructor
@Entity
public class Edificio {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String name;
    private String address;
    private String citta;


    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Postazione> postazioni;

    public Edificio(String name, String address, String citta) {
        this.name = name;
        this.address = address;
        this.citta = citta;
    }

    public Edificio(String name, String address, String citta, List<Postazione> postazioni) {
        this.name = name;
        this.address = address;
        this.citta = citta;
        this.postazioni = postazioni;
    }
}
