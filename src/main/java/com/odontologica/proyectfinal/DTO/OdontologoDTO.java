package com.odontologica.proyectfinal.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdontologoDTO {
    private Integer id;
    private String nombreCompleto;

    public OdontologoDTO(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
