package com.odontologica.proyectfinal.controller;

import com.odontologica.proyectfinal.entities.Odontologo;
import com.odontologica.proyectfinal.entities.Paciente;
import com.odontologica.proyectfinal.exceptions.BadRequestException;
import com.odontologica.proyectfinal.exceptions.NotFoundException;
import com.odontologica.proyectfinal.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    @Qualifier("OdontologoServiceImpl")
    private IService<Odontologo> odontologoIService;

    // REGISTRAR ODONTOLOGO
    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) throws Exception{
        return ResponseEntity.ok(odontologoIService.guardar(odontologo));
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Integer id) throws Exception {
        if(odontologoIService.buscar(id).isPresent()){
            return ResponseEntity.ok(odontologoIService.buscar(id).get());}
        else {
            throw new NotFoundException("No existe un odontólogo con ese ID");
        }
    }

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos() throws Exception{
        return ResponseEntity.ok(odontologoIService.buscarTodos());
    }

    // ACTUALIZAR
    @PutMapping
    public ResponseEntity<Odontologo> actualizarRegistro(@RequestBody Odontologo odontologo) throws Exception{
        ResponseEntity<Odontologo> response = ResponseEntity.notFound().build();
        if(odontologo.getId() != null && odontologoIService.buscar(odontologo.getId()).isPresent()){
            response = ResponseEntity.ok(odontologoIService.actualizar(odontologo));
        }
        return response;
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) throws Exception{
    return ResponseEntity.ok(odontologoIService.eliminar(id));
    }
}