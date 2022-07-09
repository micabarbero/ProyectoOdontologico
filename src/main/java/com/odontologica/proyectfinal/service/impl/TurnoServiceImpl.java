package com.odontologica.proyectfinal.service.impl;

import com.odontologica.proyectfinal.entities.Odontologo;
import com.odontologica.proyectfinal.entities.Paciente;
import com.odontologica.proyectfinal.entities.Turno;
import com.odontologica.proyectfinal.exceptions.BadRequestException;
import com.odontologica.proyectfinal.exceptions.NotFoundException;
import com.odontologica.proyectfinal.repository.OdontologoRepository;
import com.odontologica.proyectfinal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.odontologica.proyectfinal.repository.TurnoRepository;
import com.odontologica.proyectfinal.service.IService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service("TurnoServiceImpl")
public class TurnoServiceImpl implements IService<Turno> {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Autowired
    private OdontologoServiceImpl odontologoService;

    @Override
    public Turno guardar(Turno turno) throws BadRequestException, NotFoundException {
        // Si el body de la request está bien
        if (turno.getPaciente().getId() != null && turno.getOdontologo().getId() != null &&
                turno.getDiaTurno().isAfter(LocalDate.now())) {
            // No está en el repository
            if (odontologoService.buscar(turno.getOdontologo().getId()).isEmpty() ||
                    pacienteService.buscar(turno.getPaciente().getId()).isEmpty()) {
                throw new NotFoundException("Tu paciente u odontólogo no existe");
            }
        } else {
            throw new BadRequestException("Error en los datos ingresados");
        }
        return turnoRepository.save(turno);
    }

    @Override
    public Optional<Turno> buscar(Integer id) throws NotFoundException{
    Optional<Turno> turno = turnoRepository.findById(id);
    if(turno.isEmpty()){
        throw new NotFoundException("No existe un turno con ese ID");
    }
        return turnoRepository.findById(id);
    }


    @Override
    public List<Turno> buscarTodos() throws NotFoundException{
        List <Turno> listaTurnos = turnoRepository.findAll();
        if (listaTurnos.size() <= 0){
            throw new NotFoundException("No hay turnos cargados en este momento");
        }
        return listaTurnos;
    }

    @Override
    public boolean eliminar(Integer id) throws NotFoundException{
        boolean resultado = false;
        Optional<Turno> encontrado = turnoRepository.findById(id);
        if (encontrado.isPresent()) {
            turnoRepository.delete(encontrado.get());
            resultado = true;
        } else {
            throw new NotFoundException("No existe un turno asociado con ese ID");
        }
        return resultado;
    }

    @Override
    public Turno actualizar(Turno turno) throws BadRequestException, NotFoundException {
        Optional<Turno> turnoActualizar = turnoRepository.findById(turno.getId());

        if (turnoActualizar.isPresent()){
            turnoActualizar.get().setDiaTurno(turno.getDiaTurno());
            turnoActualizar.get().setPaciente(turno.getPaciente());
            turnoActualizar.get().setOdontologo(turno.getOdontologo());
            turnoActualizar.get().setHoraTurno(turno.getHoraTurno());
            return this.guardar(turnoActualizar.get());
        } else {
            throw new NotFoundException("No existe el turno a actualizar");
        }
    }
}
