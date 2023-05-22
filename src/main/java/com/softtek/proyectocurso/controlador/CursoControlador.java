package com.softtek.proyectocurso.controlador;

import com.softtek.proyectocurso.excepciones.ExcepcionNoEncontrado;
import com.softtek.proyectocurso.modelo.Curso;
import com.softtek.proyectocurso.servicio.ICursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping("/cursos")
public class CursoControlador {

    @Autowired
    ICursoServicio servicio;

    @GetMapping
    public ResponseEntity <List<Curso>> consultarCursos() {
        return new ResponseEntity<>(servicio.consultarCursos(), HttpStatus.OK);
    }
    @GetMapping("/hateos/{id}")
    public EntityModel<Curso> consultarCursoPorId(@PathVariable("id") int id) throws Exception {
        Curso resultadoObtenido = servicio.consultarCursoPorId(id);
        if (resultadoObtenido == null) {
            throw new ExcepcionNoEncontrado("id no encontrado" + id);
        }
        // Se crea una variable tipo WebMvcLinkBuilder para utilizar el metodo linkTo que crea enlaces hateoas
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).consultarCursoPorId(id));
        // se retorna el resultado obtenido agregando el link hateoas "linkBuilder"
        return EntityModel.of(resultadoObtenido).add(linkBuilder.withSelfRel());
    }

    @PostMapping
    public ResponseEntity<Void> crearCurso(@RequestBody Curso curso) {
        Curso resultad = servicio.crearCurso(curso);
        // se crea una url que pertenece al curso creado
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resultad.getIdCurso()).toUri();
        //devuelve una respuesta con la ubicacion de recurso creado , en este caso el curso creado
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/hateos/{id}")
    public EntityModel<Curso> modificarCurso(@PathVariable("id") int id, @RequestBody Curso curso) {

        Curso resultadoObtenido = servicio.consultarCursoPorId(curso.getIdCurso());
        if(resultadoObtenido == null) {
            throw new ExcepcionNoEncontrado("id no encontrado"+curso.getIdCurso());
        }
        Curso cursoModificado = servicio.modificarCurso(curso);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).modificarCurso(id, curso));
        return EntityModel.of(cursoModificado).add(linkBuilder.withSelfRel());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable("id")int id) {
        Curso resultadoObtenido = servicio.consultarCursoPorId(id);
        if (resultadoObtenido == null) {
            throw new ExcepcionNoEncontrado("id no encontrado" + id);
        }
        servicio.eliminarCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

   /* @GetMapping
    public ResponseEntity <List<Curso>> consultarCursos() {
        return new ResponseEntity <>(servicio.consultarCursos(), HttpStatus.OK);
    }*/

  /*  @GetMapping("/hateos")
    public EntityModel <List<Curso>> consultarCursos() {
        return  EntityModel.of(servicio.consultarCursos());
    }

   @GetMapping("/{id}")
    public ResponseEntity <Curso> consultarCursoPorId(@PathVariable("id") int id) {

        Curso resultadoObtenido = servicio.consultarCursoPorId(id);
        if(resultadoObtenido == null) {
            throw new ExcepcionNoEncontrado("id no encontrado"+id);
        }
        return new ResponseEntity<>(servicio.consultarCursoPorId(id), HttpStatus.OK);
    }*/
/* @PostMapping
    public ResponseEntity<Void> crearCurso(@RequestBody Curso curso) {
    Curso resultad = servicio.crearCurso(curso);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resultad.getIdCurso()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Curso> modificarCurso(@RequestBody Curso curso) {

        Curso resultadoObtenido = servicio.consultarCursoPorId(curso.getIdCurso());
        if(resultadoObtenido == null) {
            throw new ExcepcionNoEncontrado("id no encontrado"+curso.getIdCurso());
        }
        return new ResponseEntity(servicio.modificarCurso(curso),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable("id")int id) {
        Curso resultadoObtenido = servicio.consultarCursoPorId(id);
        if(resultadoObtenido == null) {
            throw new ExcepcionNoEncontrado("id no encontrado"+id);
        }
        servicio.eliminarCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }*/



}
