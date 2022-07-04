package com.odontologica.proyectfinal.controller;


import com.odontologica.proyectfinal.entities.Turno;
import com.odontologica.proyectfinal.service.IService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    @Qualifier("TurnoServiceImpl")
    private IService<Turno> turnoIService;

    public static Logger logger = Logger.getLogger(TurnoController.class);

    // REGISTRAR TURNO
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta = ResponseEntity.notFound().build();
            try {
                if (turno.getPaciente().getId() != null && turno.getOdontologo().getId() != null &&
                        turno.getDiaTurno().isAfter(LocalDate.now())) {
                    respuesta = ResponseEntity.ok(turnoIService.guardar(turno));
                    logger.info("Se creó correcto el turno");
                } else {
                    respuesta = ResponseEntity.badRequest().build(); // No paso la comprobación del if
                    logger.info("No paso el if");
                }
            }
        catch(Exception e){
            logger.error(e);
            logger.info("Error en la request");
            respuesta = ResponseEntity.badRequest().build(); // Si hubo un error en el body

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
