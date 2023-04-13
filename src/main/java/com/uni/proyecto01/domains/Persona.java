package com.uni.proyecto01.domains;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable
{
    private static final Long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

}
