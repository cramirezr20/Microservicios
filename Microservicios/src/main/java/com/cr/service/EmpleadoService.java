package com.cr.service;

import com.cr.model.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
	private List<Empleado> Empleados = new ArrayList<>();
	private Long nextId = 1L;

	public Empleado addEmpleado(Empleado Empleado) {
        Empleado.setId(nextId++);
        Empleados.add(Empleado);
        return Empleado;
    }

    public List<Empleado> getAllEmpleados() {
        return Empleados;
    }

    public Optional<Empleado> getEmpleadoById(Long id) {
        return Empleados.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Empleado updateEmpleado(Long id, Empleado EmpleadoActualizado) {
        Optional<Empleado> Empleado = getEmpleadoById(id);
        if (Empleado.isPresent()) {
            Empleado actualizado = Empleado.get();
            actualizado.setNombre(EmpleadoActualizado.getNombre());
            actualizado.setPuesto(EmpleadoActualizado.getPuesto());
            actualizado.setSalario(EmpleadoActualizado.getSalario());
            return actualizado;
        }
        return null;
    }

    public boolean deleteEmpleado(Long id) {
        return Empleados.removeIf(c -> c.getId().equals(id));
    }
}
