package com.softtek.proyectocurso.repositorio;

import com.softtek.proyectocurso.modelo.Curso;

import java.util.List;

public interface ICursoRepo {

    List<Curso> consultarCursos();
    Curso consultarCursoPorId(int id);
    Curso crearCurso(Curso curso);
    Curso modificarCurso(Curso curso);

    void eliminarCurso(int id);
}
