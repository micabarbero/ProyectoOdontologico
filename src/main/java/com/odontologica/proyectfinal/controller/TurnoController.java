package com.odontologica.proyectfinal.controller;

import com.odontologica.proyectfinal.entities.Odontologo;
import com.odontologica.proyectfinal.entities.Turno;
import com.odontologica.proyectfinal.service.IService;
import com.odontologica.proyectfinal.service.serviceExceptions.ServiceExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta = null;
        if (turno.getPaciente().getId() != null && turno.getOdontologo().getId() != null) { // Chequea que existe en el BODY de la request
        try{
            respuesta = ResponseEntity.ok(turnoIService.guardar(turno));
        }
        catch(Exception s){
            respuesta = ResponseEntity.badRequest().build(); // Está mal hecha la request
            }
        }
        return respuesta;
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Integer id){
        ResponseEntity<Turno> response = ResponseEntity.notFound().build();
        Turno turno = turnoIService.buscar(id).get();
        if(turno.getId() != null){
            response = ResponseEntity.ok(turno);
        }
        return response;
    }

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(turnoIService.buscarTodos());
    }

    // ACTUALIZAR
    @PutMapping
    public ResponseEntity<Turno> actualizarRegistro(@RequestBody Turno turno){
        ResponseEntity<Turno> response = ResponseEntity.notFound().build();
        if(turno.getId() != null && turnoIService.buscar(turno.getId()) != null){
            response = ResponseEntity.ok(turnoIService.actualizar(turno));
        }
        return response;
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        ResponseEntity<Turno> response = ResponseEntity.notFound().build();
        if(turnoIService.buscar(id) != null){
            turnoIService.eliminar(id);
            response = ResponseEntity.noContent().build();
        }
        return response;
    }


}
