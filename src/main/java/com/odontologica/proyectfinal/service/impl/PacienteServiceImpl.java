package com.odontologica.proyectfinal.service.impl;

import com.odontologica.proyectfinal.DTO.PacienteDTO;
import com.odontologica.proyectfinal.controller.TurnoController;
import com.odontologica.proyectfinal.entities.Domicilio;
import com.odontologica.proyectfinal.entities.Odontologo;
import com.odontologica.proyectfinal.entities.Paciente;
import com.odontologica.proyectfinal.entities.Turno;
import com.odontologica.proyectfinal.exceptions.BadRequestException;
import com.odontologica.proyectfinal.exceptions.NotFoundException;
import com.odontologica.proyectfinal.repository.DomicilioRepository;
import org.apache.log4j.Logger;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.odontologica.proyectfinal.repository.PacienteRepository;
import com.odontologica.proyectfinal.service.IService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service("PacienteServiceImpl")
public class PacienteServiceImpl implements IService<Paciente> {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DomicilioServiceImpl domicilioService;

    public static Logger logger = Logger.getLogger(PacienteServiceImpl.class);

    @Override
    public Paciente guardar(Paciente paciente) throws BadRequestException, NotFoundException {
        if (paciente.getNombre().isEmpty() || paciente.getApellido().isEmpty()) {
            if (paciente.getId() != null) {
                throw new NotFoundException("El paciente no existe");
            } else {
                throw new BadRequestException("Error en los datos ingresados");
            }
        }
        return pacienteRepository.save(paciente);
    }


    @Override
    public Optional<Paciente> buscar(Integer id) throws NotFoundException{
        if (id == null){
            throw new NotFoundException("No existe un paciente con ese ID");
        }
        return pacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> buscarTodos() throws NotFoundException {
        List<Paciente> listaPaciente = pacienteRepository.findAll();
        if(listaPaciente.size() <= 0){
            throw new NotFoundException("No hay pacientes cargados en este momento");
        }
        return listaPaciente;
    }


    @Override
    public boolean eliminar(Integer id) throws BadRequestException {
        boolean resultado = false;
        Optional<Paciente> encontrado = pacienteRepository.findById(id);
        if (encontrado.isEmpty()) {
            if (pacienteRepository.findById(id).isEmpty()) {
                throw new BadRequestException("No existe un paciente con ese ID");
            }
        } else {
            pacienteRepository.deleteById(id);
            logger.info("Se borró el paciente con id" + id);
            resultado = true;
        }
        return resultado;
    }


    public Paciente actualizar(Paciente paciente) throws BadRequestException, NotFoundException {
        Optional<Paciente> pacienteActualizar = pacienteRepository.findById(paciente.getId());

        if (pacienteActualizar.isPresent()) {
            pacienteActualizar.get().setNombre(paciente.getNombre());
            pacienteActualizar.get().setApellido(paciente.getApellido());
            pacienteActualizar.get().setDni(paciente.getDni());
            pacienteActualizar.get().setFechaIngreso(paciente.getFechaIngreso());

            Domicilio domicilioActualizar = domicilioService.actualizar(paciente.getDomicilio());
            domicilioActualizar.setCalle(domicilioActualizar.getCalle());
            domicilioActualizar.setNumero(domicilioActualizar.getNumero());
            domicilioActualizar.setProvincia(domicilioActualizar.getProvincia());
            domicilioActualizar.setLocalidad(domicilioActualizar.getLocalidad());
            return this.guardar(pacienteActualizar.get());
        } else {
            throw new BadRequestException("Error en los datos al actualizar al paciente.");
        }
    }
//
//    public boolean actualizarDomicilio (Paciente paciente,Domicilio domicilio) throws Exception{
//        domicilioService.actualizar(domicilio.getCalle().)
//    }
}
