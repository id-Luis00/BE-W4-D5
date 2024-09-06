package com.edi_Luis;


import com.edi_Luis.entities.Utente;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    Faker faker;

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

}
