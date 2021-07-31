package com.ejerciciopropuesto.ejercicioseis.controller;

import com.ejerciciopropuesto.ejercicioseis.entity.EmpleadoPlanta;
import com.ejerciciopropuesto.ejercicioseis.repository.EmpleadoPlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class EmpleadoPlantaController {

    private EmpleadoPlantaRepository repository;

    @Autowired
    public  EmpleadoPlantaController(EmpleadoPlantaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/empleados/planta")
    public @ResponseBody Iterable<EmpleadoPlanta> listaEmpleadosPlanta() {return repository.findAll();}

    @GetMapping(value = "/empleados/planta/{empleadoId}")
    public @ResponseBody Optional<EmpleadoPlanta> verEmpleadoPlanta (@PathVariable("empleadoId") Long id) {
        return repository.findById(id);
    }
}
