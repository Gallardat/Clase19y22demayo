package com.softtek.proyectocurso.servicio;

import com.softtek.proyectocurso.modelo.Curso;
import com.softtek.proyectocurso.repositorio.ICursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServicio implements  ICursoServicio{

    @Autowired
    ICursoRepo repo;
    @Override
    public List<Curso> consultarCursos() {
        return repo.consultarCursos();
    }

    @Override
    public Curso consultarCursoPorId(int id) {
        return repo.consultarCursoPorId(id);
    }

    @Override
    public Curso crearCurso(Curso curso) {

        return repo.crearCurso(curso);
    }

    @Override
    public Curso modificarCurso(Curso curso) {

    return repo.modificarCurso(curso);
    }

    @Override
    public void eliminarCurso(int id) {
        repo.eliminarCurso(id);
    }


}
