package com.odontologica.proyectfinal.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.odontologica.proyectfinal.entities.Odontologo;
import com.odontologica.proyectfinal.entities.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO implements Serializable {

    private String pacienteFullName;
    private String odontologoFullName;
    private LocalDate diaTurno;
    private LocalTime horaTurno;



}
