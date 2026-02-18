package com.duoc.productor_horarios.controller;

import com.duoc.productor_horarios.model.InfoRuta;
import com.duoc.productor_horarios.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @PostMapping("/actualizar")
    public String actualizarRuta(@RequestBody InfoRuta info) {
        horarioService.enviarActualizacion(info);
        return "Ruta " + info.getIdRuta() + " enviada correctamente.";
    }
}