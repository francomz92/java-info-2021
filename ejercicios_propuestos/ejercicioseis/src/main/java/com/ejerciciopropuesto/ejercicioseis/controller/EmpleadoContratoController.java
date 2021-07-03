package com.ejerciciopropuesto.ejercicioseis.controller;

import com.ejerciciopropuesto.ejercicioseis.entity.Empleado;
import com.ejerciciopropuesto.ejercicioseis.entity.EmpleadoContrato;
import com.ejerciciopropuesto.ejercicioseis.repository.EmpleadoContratoRepository;
import com.ejerciciopropuesto.ejercicioseis.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class EmpleadoContratoController {

    @Autowired
    private EmpleadoContratoRepository repository;


    @GetMapping(value = "/empleados/contrato")
    public @ResponseBody Iterable<EmpleadoContrato> listaEmpleadosContrato() {return repository.findAll();}

    @GetMapping(value = "/empleados/contrato/{empleadoId}")
    public @ResponseBody Optional<EmpleadoContrato> verEmpleadoContrato(@PathVariable("empleadoId") Long id) {
        return repository.findById(id);
    }
}
