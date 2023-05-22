package com.softtek.proyectocurso.servicio;

import com.softtek.proyectocurso.modelo.Curso;

import java.util.List;

public interface ICursoServicio {
    List<Curso> consultarCursos();
    Curso consultarCursoPorId(int id);
    Curso crearCurso(Curso curso);
    Curso modificarCurso(Curso curso);
    void eliminarCurso(int id);
}
