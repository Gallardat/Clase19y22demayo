package com.softtek.proyectocurso.excepciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Excepcionespuesta {

    private LocalDateTime fecha;
    private String mensaje;
    private String detalle;
}
