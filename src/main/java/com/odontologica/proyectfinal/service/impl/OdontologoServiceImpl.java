package com.odontologica.proyectfinal.service.impl;

import com.odontologica.proyectfinal.entities.Odontologo;
import com.odontologica.proyectfinal.entities.Paciente;
import com.odontologica.proyectfinal.exceptions.BadRequestException;
import com.odontologica.proyectfinal.exceptions.NotFoundException;
import org.apache.log4j.Logger;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.odontologica.proyectfinal.repository.OdontologoRepository;
import com.odontologica.proyectfinal.service.IService;

import java.util.List;
import java.util.Optional;

@Service("OdontologoServiceImpl")
public class OdontologoServiceImpl implements IService<Odontologo> {

    public static Logger logger = Logger.getLogger(OdontologoServiceImpl.class);

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Override
    public Odontologo guardar(Odontologo odontologo) throws BadRequestException, NotFoundException{
        if (odontologo.getNombre().isEmpty() || odontologo.getApellido().isEmpty() || odontologo.getMatricula().isEmpty()){
            if(odontologo.getId() != null){
                throw new NotFoundException("El odontólogo no existe");
            } else {
                throw new BadRequestException("Error en los datos ingresados");
            }
        }
        return odontologoRepository.save(odontologo);
    }


    @Override
    public Optional<Odontologo> buscar(Integer id) throws NotFoundException {
        Optional <Odontologo> odontologo = odontologoRepository.findById(id);
        if (odontologo.isEmpty()){
            throw new NotFoundException("El odontólogo con ID " + id + " que estás buscando no existe");
        }
        return odontologoRepository.findById(id);
    }

    @Override
    public List<Odontologo> buscarTodos() throws NotFoundException{
        List<Odontologo> listaOdontologo = odontologoRepository.findAll();
        if(listaOdontologo.size() <= 0) {
            throw new NotFoundException("No hay odontólogos cargados en este momento");
        }
        return listaOdontologo;
    }


    @Override
    public boolean eliminar(Integer id) throws BadRequestException{
        boolean resultado = false;
        Optional<Odontologo> encontrado = odontologoRepository.findById(id);
        if(encontrado.isEmpty()){
            if(odontologoRepository.findById(id).isEmpty()){
                throw new BadRequestException("No existe un odontólgo con ese ID");
            }}
            else {
                odontologoRepository.deleteById(id);
                logger.info("Se borró el odontólogo correctamente");
                resultado = true;
        }
        return resultado;
    }


    @Override
    public Odontologo actualizar(Odontologo odontologo) throws BadRequestException, NotFoundException {
        Optional<Odontologo> odontologoActualizar = odontologoRepository.findById(odontologo.getId());
        if(odontologoActualizar.isPresent()){
            odontologoActualizar.get().setNombre(odontologo.getNombre());
            odontologoActualizar.get().setApellido(odontologo.getApellido());
            odontologoActualizar.get().setMatricula(odontologo.getMatricula());
            return this.guardar(odontologoActualizar.get());
        } else {
            throw new BadRequestException("Error en los datos al actualizar el odontólogo.");
        }
    }
}

