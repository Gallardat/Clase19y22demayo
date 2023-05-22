package com.softtek.proyectocurso.excepciones;

public class ExcepcionNoEncontrado extends RuntimeException {

    private  static final long serialVersionUID = 1L;
    public ExcepcionNoEncontrado(String mensaje) {
        super(mensaje);
    }
}
