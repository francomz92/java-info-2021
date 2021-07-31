package com.ejerciciopropuesto.ejercicioseis.controller;

import com.ejerciciopropuesto.ejercicioseis.entity.Empleado;
import com.ejerciciopropuesto.ejercicioseis.entity.EmpleadoJornada;
import com.ejerciciopropuesto.ejercicioseis.repository.EmpleadoJornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class EmpleadoJornadaController {

    private EmpleadoJornadaRepository repository;

    @Autowired
    public EmpleadoJornadaController(EmpleadoJornadaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/empleados/jornada")
    public @ResponseBody Iterable<EmpleadoJornada> listaEmpleadosJornada() {return repository.findAll();}

    @GetMapping(value = "/empleados/jornada/{empleadoId}")
    public @ResponseBody Optional<EmpleadoJornada> verEmpleadoJornada(@PathVariable("empleadoId") Long id) {
        return repository.findById(id);
    }
}
