package com.cr.model;

public class Empleado {

	private Long id;
    public Empleado(Long id, String nombre, String puesto, String salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = salario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	private String nombre;
    private String puesto;
    private String salario;

}
