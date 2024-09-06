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


    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Postazione> postazioni;

    public Edificio(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Edificio(String name, String address, List<Postazione> postazioni) {
        this.name = name;
        this.address = address;
        this.postazioni = postazioni;
    }
}
