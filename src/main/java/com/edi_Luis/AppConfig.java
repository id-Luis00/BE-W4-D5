package com.edi_Luis;


import com.edi_Luis.entities.Edificio;
import com.edi_Luis.entities.Postazione;
import com.edi_Luis.entities.Prenotazione;
import com.edi_Luis.entities.Utente;
import com.edi_Luis.enums.TypePostazione;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class AppConfig {


    Faker faker = new Faker();

    @Bean
    public Utente utente1() {
        return new Utente(faker.name().username(), faker.name().fullName(), "example@gmail.com");
    }

    @Bean
    public Utente utente2() {
        return new Utente(faker.name().username(), faker.name().fullName(), "example@gmail.com");
    }

    @Bean
    public Utente utente3() {
        return new Utente(faker.name().username(), faker.name().fullName(), "example@gmail.com");
    }

    @Bean
    public Edificio edificio1() {
        return new Edificio("edificio A", "Viale Italia 86");
    }

    @Bean
    public Edificio edificio2() {
        return new Edificio("edificio B", "Via del Corso 10");
    }

    @Bean
    public Edificio edificio3() {
        return new Edificio("edificio C", "Via Ancona 13b");
    }

    @Bean
    public Postazione postazione1() {
        return new Postazione(faker.lorem().characters(10, 100), TypePostazione.PRIVATO, "10", edificio1());
    }

    @Bean
    public Postazione postazione2() {
        return new Postazione(faker.lorem().characters(10, 100), TypePostazione.OPEN_SPACE, "5", edificio1());
    }

    @Bean
    public Postazione postazione3() {
        return new Postazione(faker.lorem().characters(10, 50), TypePostazione.SALA_RIUNIONI, "35", edificio3());
    }

    @Bean
    public Prenotazione prenotazione1() {
        return new Prenotazione(LocalDate.of(2024, 9, 6), postazione1(), utente1());
    }

}
