package com.edi_Luis.repositories;

import com.edi_Luis.entities.Postazione;
import com.edi_Luis.enums.TypePostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

    @Query("SELECT p FROM Postazione p WHERE p.typePostazione = :typePostazione")
    List<Postazione> findPostazioniByTypePostazione(@Param("typePostazione") TypePostazione typePostazione);

}
