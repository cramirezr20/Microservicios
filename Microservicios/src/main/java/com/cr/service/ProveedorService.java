package com.cr.service;

import com.cr.model.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProveedorService {
	private List<Proveedor> Proveedors = new ArrayList<>();
	private Long nextId = 1L;

	public Proveedor addProveedor(Proveedor Proveedor) {
        Proveedor.setId(nextId++);
        Proveedors.add(Proveedor);
        return Proveedor;
    }

    public List<Proveedor> getAllProveedors() {
        return Proveedors;
    }

    public Optional<Proveedor> getProveedorById(Long id) {
        return Proveedors.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Proveedor updateProveedor(Long id, Proveedor ProveedorActualizado) {
        Optional<Proveedor> Proveedor = getProveedorById(id);
        if (Proveedor.isPresent()) {
            Proveedor actualizado = Proveedor.get();
            actualizado.setNombre(ProveedorActualizado.getNombre());
            actualizado.setDireccion(ProveedorActualizado.getDireccion());
            actualizado.setTelefono(ProveedorActualizado.getTelefono());
            return actualizado;
        }
        return null;
    }

    public boolean deleteProveedor(Long id) {
        return Proveedors.removeIf(c -> c.getId().equals(id));
    }
}
