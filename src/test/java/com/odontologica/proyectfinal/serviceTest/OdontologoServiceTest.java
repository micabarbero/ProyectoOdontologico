package com.odontologica.proyectfinal.serviceTest;

import com.odontologica.proyectfinal.entities.Odontologo;
import com.odontologica.proyectfinal.exceptions.NotFoundException;
import com.odontologica.proyectfinal.service.IService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    @Qualifier("OdontologoServiceImpl")
    private IService<Odontologo> odontologoService;

    private Odontologo odontologo;

    @BeforeEach
    public void cargarDataSet() {
        odontologo = new Odontologo();
        odontologo.setMatricula("123");
        odontologo.setNombre("MicaTest");
        odontologo.setApellido("BarberoTest");
    }

    @Test
    public void crearOdontologo() throws Exception {
        Odontologo o1 = new Odontologo();
        o1.setNombre("Micaela");
        o1.setApellido("Barbero");
        o1.setMatricula("123");
        Odontologo o = odontologoService.guardar(o1);
        Assertions.assertNotNull(odontologoService.buscar(1));
    }

    @Test
    public void actualizarOdontologo() throws Exception {
        Odontologo o = odontologoService.guardar(odontologo);
        Odontologo odontologoOriginal = odontologoService.buscar(o.getId()).get();
        o.setNombre("Fabricio");
        Odontologo actualizado = odontologoService.actualizar(o);
        Assertions.assertNotEquals(actualizado, odontologoOriginal);
    }

    @Test
    public void eliminarOdontologo() throws Exception {
        Odontologo o = odontologoService.guardar(odontologo);
        Assertions.assertNotNull(odontologoService.buscar(o.getId()));
        odontologoService.eliminar(o.getId());
        Assertions.assertThrows(NotFoundException.class, () -> odontologoService.buscar(o.getId()));
    }

    @Test
    public void traerTodos() throws Exception {
        odontologoService.guardar(odontologo);
        Assertions.assertNotEquals(0, odontologoService.buscarTodos().size());
    }
}
