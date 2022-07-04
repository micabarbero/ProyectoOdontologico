package com.odontologica.proyectfinal.service.impl;
import com.odontologica.proyectfinal.entities.Turno;
import com.odontologica.proyectfinal.repository.OdontologoRepository;
import com.odontologica.proyectfinal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.odontologica.proyectfinal.repository.TurnoRepository;
import com.odontologica.proyectfinal.service.IService;

import java.util.List;
import java.util.Optional;

@Service("TurnoServiceImpl")
public class TurnoServiceImpl implements IService<Turno> {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Override
    public Turno guardar(Turno turno) {
            if (odontologoRepository.findById(turno.getOdontologo().getId()) != null
                    && pacienteRepository.findById(turno.getOdontologo().getId()) != null) { // Chequea que exista en el REPOSITORY
                return turnoRepository.save(turno);
            } return null;
    }

    @Override
    public Optional<Turno> buscar(Integer id) {
        return turnoRepository.findById(id);
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public boolean eliminar(Integer id) {
        boolean resultado = false;
        Optional<Turno> encontrado = turnoRepository.findById(id);
        if(!encontrado.isEmpty()){
            turnoRepository.delete(encontrado.get());
            resultado = true;
        }
        return resultado;
    }

    @Override
    public Turno actualizar(Turno turno) {
       Turno turnoActualizar = turnoRepository.findById(turno.getId()).get();
       turnoActualizar.setDiaTurno(turno.getDiaTurno());
       turnoActualizar.setPaciente(turno.getPaciente());
       turnoActualizar.setOdontologo(turno.getOdontologo());
       turnoActualizar.setHoraTurno(turno.getHoraTurno());
        return this.guardar(turnoActualizar);
    }
}
