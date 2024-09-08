package com.cr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cr.model.Empleado;
import com.cr.service.EmpleadoService;

@RestController
@RequestMapping("/Empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService EmpleadoService;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado createEmpleado(@RequestBody Empleado Empleado) {
        return EmpleadoService.addEmpleado(Empleado);
    }
    
	@GetMapping
    public List<Empleado> getAllEmpleados() {
        return EmpleadoService.getAllEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado getEmpleadoById(@PathVariable Long id) {
        return EmpleadoService.getEmpleadoById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado"));
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable Long id, @RequestBody Empleado EmpleadoActualizado) {
        Empleado Empleado = EmpleadoService.updateEmpleado(id, EmpleadoActualizado);
        if (Empleado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        }
        return Empleado;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmpleado(@PathVariable Long id) {
        if (!EmpleadoService.deleteEmpleado(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        }
    }

}
	

