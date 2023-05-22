package com.softtek.proyectocurso.repositorio;

import com.softtek.proyectocurso.modelo.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class CursoRepo implements ICursoRepo{

    Scanner teclado = new Scanner(System.in);
    List<Curso>cursos= new ArrayList<>();
    @Override
    public List<Curso> consultarCursos() {
        cursos.add(new Curso(1,"JAVA",2,1));
        cursos.add(new Curso(2,"SPRING",3,2));
        return cursos;
    }

    @Override
    public Curso consultarCursoPorId(int id) {
     Curso curso=this.cursos.stream().
             filter(curso1->curso1.getIdCurso()==id).
             findFirst().orElse(null);
    return curso;
    }

    @Override
    public Curso crearCurso(Curso curso) {
        this.cursos.add(curso);
        return curso;
    }

    @Override
    public Curso modificarCurso(Curso curso) {
        for (int i = 0; i < cursos.size(); i++) {
            Curso cursoN = cursos.get(i);
            if (cursoN.getIdCurso() == curso.getIdCurso()) {
                cursoN.setIdProfesor(curso.getIdProfesor());
                cursoN.setNombreCurso(curso.getNombreCurso());
                cursoN.setIdCurso(curso.getIdCurso());
                cursoN.setDuracion(curso.getDuracion());
                break;
            }
        }
     return curso;
    }


    @Override
    public void eliminarCurso(int id) {

        this.cursos.removeIf(c->c.getIdCurso()==id);
    }
}