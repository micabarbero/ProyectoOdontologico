package com.odontologica.proyectfinal.service.impl;

import com.odontologica.proyectfinal.DTO.PacienteDTO;
import com.odontologica.proyectfinal.entities.Domicilio;
import com.odontologica.proyectfinal.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.odontologica.proyectfinal.repository.PacienteRepository;
import com.odontologica.proyectfinal.service.IService;

import java.util.List;
import java.util.Optional;

@Service("PacienteServiceImpl")
public class PacienteServiceImpl implements IService<Paciente> {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public boolean eliminar(Integer id) {
        boolean resultado = false;
        Optional<Paciente> encontrado = pacienteRepository.findById(id);
        if(!encontrado.isEmpty()){
            pacienteRepository.delete(encontrado.get());
            resultado = true;
        }
        return resultado;
    }

    public Paciente actualizar(Paciente paciente){
        Paciente pacienteActualizar = pacienteRepository.findById(paciente.getId()).get(); // Acá tengo al paciente A actualizar
        pacienteActualizar.setNombre(paciente.getNombre());
        pacienteActualizar.setApellido(paciente.getApellido());
        pacienteActualizar.setDni(paciente.getDni());
        pacienteActualizar.setFechaIngreso(paciente.getFechaIngreso());

        return this.guardar(pacienteActualizar);
        // estoy parada en el com.odontologica.proyectfinal.service, entonces uso el metodo guardar de acá y le paso el paciente actualizado.
    }

    public boolean actualizarDomicilio (Paciente paciente, Domicilio domicilio) {
        Paciente pacienteActualizar = this.buscar(paciente.getId()).get();
        pacienteActualizar.setDomicilio(domicilio);
        this.actualizar(pacienteActualizar);
        return true;
    }
}
