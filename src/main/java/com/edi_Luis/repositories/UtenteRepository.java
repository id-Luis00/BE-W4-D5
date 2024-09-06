package com.edi_Luis.repositories;

import com.edi_Luis.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, UUID> {

    // qui inseriro le mie query personalizzate

    boolean existsByUsername(String username);
}
