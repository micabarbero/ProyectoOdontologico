package com.odontologica.proyectfinal.controller;

import com.odontologica.proyectfinal.entities.Odontologo;
import com.odontologica.proyectfinal.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    @Qualifier("OdontologoServiceImpl")
    private IService<Odontologo> odontologoIService;

    // REGISTRAR PACIENTE
    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoIService.guardar(odontologo));
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Integer id){
        ResponseEntity<Odontologo> response = ResponseEntity.notFound().build();
        Odontologo odontologo = odontologoIService.buscar(id).get();
        if(odontologo.getId() != null){
            response = ResponseEntity.ok(odontologo);
        }
        return response;
    }

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoIService.buscarTodos());
    }

    // ACTUALIZAR
    @PutMapping
    public ResponseEntity<Odontologo> actualizarRegistro(@RequestBody Odontologo odontologo){
        ResponseEntity<Odontologo> response = ResponseEntity.notFound().build();
        if(odontologo.getId() != null && odontologoIService.buscar(odontologo.getId()) != null){
            response = ResponseEntity.ok(odontologoIService.actualizar(odontologo));
        }
        return response;
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        ResponseEntity<Odontologo> response = ResponseEntity.notFound().build();
        if(odontologoIService.buscar(id) != null){
            odontologoIService.eliminar(id);
            response = ResponseEntity.noContent().build();
        }
        return response;
    }


}
