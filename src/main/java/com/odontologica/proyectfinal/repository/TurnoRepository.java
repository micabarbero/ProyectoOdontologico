package com.odontologica.proyectfinal.repository;

import com.odontologica.proyectfinal.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
}
