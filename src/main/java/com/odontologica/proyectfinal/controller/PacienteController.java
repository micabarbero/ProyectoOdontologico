package com.odontologica.proyectfinal.controller;

import com.odontologica.proyectfinal.DTO.PacienteDTO;
import com.odontologica.proyectfinal.entities.Domicilio;
import com.odontologica.proyectfinal.entities.Paciente;
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
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) throws Exception{
        return ResponseEntity.ok(pacienteIService.guardar(paciente));
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity buscarPaciente(@PathVariable Integer id) throws Exception{
        ResponseEntity response = ResponseEntity.notFound().build();
        PacienteDTO pacienteFront = new PacienteDTO();
        try {
            Paciente pacienteBuscado = pacienteIService.buscar(id).get();
            if (pacienteBuscado.getId() != null) {
                pacienteFront.setNombreCompleto(pacienteBuscado.getNombre() + " " + pacienteBuscado.getApellido());
                pacienteFront.setDni(pacienteBuscado.getDni());
                pacienteFront.setId(pacienteBuscado.getId());
                response = ResponseEntity.ok(pacienteFront);
            }
            }
        catch (Exception e) {
            logger.info(e);
            response = ResponseEntity.badRequest().build();

            }

        return response;
    }

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos() throws Exception{
        return ResponseEntity.ok(pacienteIService.buscarTodos());
    }

    // ACTUALIZAR
    @PutMapping
    public ResponseEntity<Paciente> actualizarRegistro(@RequestBody Paciente paciente) throws Exception{
        ResponseEntity<Paciente> response = ResponseEntity.notFound().build();
        if(paciente.getId() != null && pacienteIService.buscar(paciente.getId()) != null){
        // Este lo busca en el body (Si le estan mandado por postman) && este lo busca en el com.odontologica.proyectfinal.repository
            response = ResponseEntity.ok(pacienteIService.actualizar(paciente));
        }
        return response;
    }


    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) throws Exception{
        ResponseEntity<Paciente> response = ResponseEntity.notFound().build();
        if(pacienteIService.buscar(id) != null){
            pacienteIService.eliminar(id);
            response = ResponseEntity.noContent().build();
        }
        return response;
    }


}
