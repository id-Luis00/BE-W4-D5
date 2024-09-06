package com.edi_Luis.repositories;

import com.edi_Luis.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EdificioRepository extends JpaRepository<Edificio, UUID> {
}
