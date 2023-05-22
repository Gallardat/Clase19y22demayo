package com.softtek.proyectocurso.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Curso {
    private int idCurso;
    private String nombreCurso;
    private int duracion;
    private int idProfesor;

}
