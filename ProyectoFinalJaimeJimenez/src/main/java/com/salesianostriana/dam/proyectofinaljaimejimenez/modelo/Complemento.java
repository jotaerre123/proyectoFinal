package com.salesianostriana.dam.proyectofinaljaimejimenez.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Complemento {
	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String tipo;
	private String rareza;
	private String descripcion;
	private String moneda;
	private int precio;
	
	public Complemento(String nombre, String tipo, String rareza, String descripcion, String moneda, int precio) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.rareza = rareza;
		this.descripcion = descripcion;
		this.moneda = moneda;
		this.precio = precio;
	}
	
	
	
	
}
