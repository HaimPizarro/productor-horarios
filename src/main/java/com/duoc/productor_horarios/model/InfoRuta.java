package com.duoc.productor_horarios.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoRuta implements Serializable {
    private String idRuta;
    private String nuevoHorarioSalida;
    private String nuevoHorarioLlegada;
    private String estado; 
}