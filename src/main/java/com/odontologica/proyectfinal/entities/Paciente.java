package com.odontologica.proyectfinal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaIngreso = LocalDate.now();

    // Join con Domicilio
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="domicilio_id")
    private Domicilio domicilio;

    // Join con Turnos
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    // Join con Odontologos
    //@JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="odontologo_id", nullable = true)
    //private Odontologo odontologo;


    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", domicilio=" + domicilio +
                '}';
    }
}
