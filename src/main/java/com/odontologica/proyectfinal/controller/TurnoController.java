package com.odontologica.proyectfinal.controller;


import com.odontologica.proyectfinal.entities.Turno;
import com.odontologica.proyectfinal.exceptions.BadRequestException;
import com.odontologica.proyectfinal.exceptions.NotFoundException;
import com.odontologica.proyectfinal.service.IService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    @Qualifier("TurnoServiceImpl")
    private IService<Turno> turnoIService;


    // REGISTRAR TURNO
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) throws Exception {
        return ResponseEntity.ok(turnoIService.guardar(turno));
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Integer id) throws Exception{
        if(turnoIService.buscar(id).isPresent()){
            return ResponseEntity.ok(turnoIService.buscar(id).get());
        } else {
            throw new NotFoundException("No existe un turno con este ID");
        }

    }

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos() throws Exception{
        return ResponseEntity.ok(turnoIService.buscarTodos());
    }

    // ACTUALIZAR
    @PutMapping
    public ResponseEntity<Turno> actualizarRegistro(@RequestBody Turno turno) throws Exception{
        ResponseEntity<Turno> response = ResponseEntity.notFound().build();
        if(turno.getId() != null && turnoIService.buscar(turno.getId()).isPresent()){
            response = ResponseEntity.ok(turnoIService.actualizar(turno));
        }
        return response;
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) throws Exception{
        return ResponseEntity.ok(turnoIService.eliminar(id));
    }

}
