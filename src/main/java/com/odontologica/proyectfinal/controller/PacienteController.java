package com.odontologica.proyectfinal.controller;

import com.odontologica.proyectfinal.DTO.PacienteDTO;
import com.odontologica.proyectfinal.entities.Domicilio;
import com.odontologica.proyectfinal.entities.Odontologo;
import com.odontologica.proyectfinal.entities.Paciente;
import com.odontologica.proyectfinal.exceptions.BadRequestException;
import com.odontologica.proyectfinal.exceptions.NotFoundException;
import com.odontologica.proyectfinal.service.IService;
import com.odontologica.proyectfinal.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    @Qualifier("PacienteServiceImpl")
    private IService<Paciente> pacienteIService;

    public static Logger logger = Logger.getLogger(PacienteController.class);

    // REGISTRAR PACIENTE
    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) throws Exception {
        logger.info("Se registró correctamente un paciente");
        return ResponseEntity.ok(pacienteIService.guardar(paciente));
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(pacienteIService.buscar(id).get());
    }


    // LISTAR
    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos() throws Exception {
        return ResponseEntity.ok(pacienteIService.buscarTodos());
    }

    // ACTUALIZAR
    @PutMapping
    public ResponseEntity<Paciente> actualizarRegistro(@RequestBody Paciente paciente) throws Exception {
        ResponseEntity<Paciente> response = ResponseEntity.notFound().build();
        if (paciente.getId() != null && pacienteIService.buscar(paciente.getId()).isPresent()) {
            response = ResponseEntity.ok(pacienteIService.actualizar(paciente));
        }
        return response;
    }


    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(pacienteIService.eliminar(id));
    }
}