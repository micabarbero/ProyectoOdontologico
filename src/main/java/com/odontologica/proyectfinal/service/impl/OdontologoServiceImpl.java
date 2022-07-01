package com.odontologica.proyectfinal.service.impl;

import com.odontologica.proyectfinal.entities.Odontologo;
import com.odontologica.proyectfinal.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.odontologica.proyectfinal.repository.OdontologoRepository;
import com.odontologica.proyectfinal.service.IService;

import java.util.List;
import java.util.Optional;

@Service("OdontologoServiceImpl")
public class OdontologoServiceImpl implements IService<Odontologo> {

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> buscar(Integer id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public boolean eliminar(Integer id) {
        boolean resultado = false;
        Optional<Odontologo> encontrado = odontologoRepository.findById(id);
        if(!encontrado.isEmpty()){
            odontologoRepository.delete(encontrado.get());
            resultado = true;
        }
        return resultado;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Odontologo odontologoActualizar = odontologoRepository.findById(odontologo.getId()).get();
        odontologoActualizar.setNombre(odontologo.getNombre());
        odontologoActualizar.setApellido(odontologo.getApellido());
        odontologoActualizar.setMatricula(odontologo.getMatricula());
        return this.guardar(odontologoActualizar);
    }
}

