package com.odontologica.proyectfinal.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {
    private Integer id;
    private String nombreCompleto;


}
