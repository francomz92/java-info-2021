package com.ejerciciopropuesto.ejercicioseis.controller;

import com.ejerciciopropuesto.ejercicioseis.entity.Empleado;
import com.ejerciciopropuesto.ejercicioseis.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.events.Event;

import java.util.Optional;

@Controller
public class EmpleadoController {

    private EmpleadoRepository repository;

    @Autowired
    public EmpleadoController(EmpleadoRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/empleados")
    public @ResponseBody Iterable<Empleado> listaEmpleados() {
        return repository.findAll();
    }

    @GetMapping(value = "/empleados/{empleadoId}")
    public @ResponseBody Optional<Empleado> verEmpleado(@PathVariable("empleadoId") Long id) {
        return repository.findById(id);
    }
}
