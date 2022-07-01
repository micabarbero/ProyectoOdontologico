package com.odontologica.proyectfinal.controller;

import com.odontologica.proyectfinal.entities.Paciente;
import com.odontologica.proyectfinal.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    @Qualifier("PacienteServiceImpl") // Para que sepa que Impl usar en el Service
    private IService<Paciente> pacienteIService;

    // REGISTRAR PACIENTE
    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteIService.guardar(paciente));
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Integer id){
        ResponseEntity<Paciente> response = ResponseEntity.notFound().build();
        Paciente paciente = pacienteIService.buscar(id).get();
        if(paciente.getId() != null){
            response = ResponseEntity.ok(paciente);
        }
        return response;
    }

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteIService.buscarTodos());
    }

    // ACTUALIZAR
    @PutMapping
    public ResponseEntity<Paciente> actualizarRegistro(@RequestBody Paciente paciente){
        ResponseEntity<Paciente> response = ResponseEntity.notFound().build();
        if(paciente.getId() != null && pacienteIService.buscar(paciente.getId()) != null){
        // Este lo busca en el body (Si le estan mandado por postman) && este lo busca en el com.odontologica.proyectfinal.repository
            response = ResponseEntity.ok(pacienteIService.actualizar(paciente));
        }
        return response;
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        ResponseEntity<Paciente> response = ResponseEntity.notFound().build();
        if(pacienteIService.buscar(id) != null){
            pacienteIService.eliminar(id);
            response = ResponseEntity.noContent().build();
        }
        return response;
    }


}
