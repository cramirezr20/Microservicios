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

import com.cr.model.Proveedor;
import com.cr.service.ProveedorService;

@RestController
@RequestMapping("/Proveedors")
public class ProveedorController {

	@Autowired
	private ProveedorService ProveedorService;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor createProveedor(@RequestBody Proveedor Proveedor) {
        return ProveedorService.addProveedor(Proveedor);
    }
    
	@GetMapping
    public List<Proveedor> getAllProveedors() {
        return ProveedorService.getAllProveedors();
    }

    @GetMapping("/{id}")
    public Proveedor getProveedorById(@PathVariable Long id) {
        return ProveedorService.getProveedorById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado"));
    }

    @PutMapping("/{id}")
    public Proveedor updateProveedor(@PathVariable Long id, @RequestBody Proveedor ProveedorActualizado) {
        Proveedor Proveedor = ProveedorService.updateProveedor(id, ProveedorActualizado);
        if (Proveedor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        }
        return Proveedor;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProveedor(@PathVariable Long id) {
        if (!ProveedorService.deleteProveedor(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado");
        }
    }

}
	

