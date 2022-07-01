package com.odontologica.proyectfinal.service.impl;

import com.odontologica.proyectfinal.entities.Domicilio;
import com.odontologica.proyectfinal.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.odontologica.proyectfinal.repository.DomicilioRepository;
import com.odontologica.proyectfinal.service.IService;

import java.util.List;
import java.util.Optional;

@Service("DomicilioServiceImpl")
public class DomicilioServiceImpl implements IService<Domicilio> {

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Optional<Domicilio> buscar(Integer id) {
        return domicilioRepository.findById(id);
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return domicilioRepository.findAll();
    }

    @Override
    public boolean eliminar(Integer id) {
        boolean resultado = false;
        Optional<Domicilio> encontrado = domicilioRepository.findById(id);
        if(!encontrado.isEmpty()){
            domicilioRepository.delete(encontrado.get());
            resultado = true;
        }
        return resultado;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        Domicilio domicilioActualizar = domicilioRepository.findById(domicilio.getId()).get();
        domicilioActualizar.setCalle(domicilio.getCalle());
        domicilioActualizar.setNumero(domicilio.getNumero());
        domicilioActualizar.setLocalidad(domicilio.getLocalidad());
        domicilioActualizar.setProvincia(domicilio.getLocalidad());
        return this.guardar(domicilioActualizar);
    }
}
