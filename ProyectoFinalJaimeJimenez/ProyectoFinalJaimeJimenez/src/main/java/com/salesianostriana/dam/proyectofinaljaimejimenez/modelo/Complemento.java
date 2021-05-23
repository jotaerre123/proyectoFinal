package com.salesianostriana.dam.proyectofinaljaimejimenez.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complemento {
	@Id
	@GeneratedValue
	private long id;

	private String nombre;

	@ManyToOne
	private Rareza rareza; // legendario o excepcional

	private String descripcion;

	@ManyToOne
	private Tipo tipo; // tipo puede variar entre 4: diseño de arma, gesto, shader(colores), vehículo

	@ManyToOne
	private Pago pago; // 2 formas de pago: Plata o Polvo Luminoso

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate renovacion;

	private String imagen;

	public Complemento(String nombre, Rareza rareza, String descripcion, Tipo tipo, Pago pago) {
		super();
		this.nombre = nombre;
		this.rareza = rareza;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.pago = pago;
	}

	public Complemento(String nombre, Rareza rareza, String descripcion, Tipo tipo, Pago pago, LocalDate renovacion) {
		super();
		this.nombre = nombre;
		this.rareza = rareza;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.pago = pago;
		this.renovacion = renovacion;
	}

	public Complemento(String nombre, Rareza rareza, String descripcion, Tipo tipo, Pago pago, LocalDate renovacion,
			String imagen) {
		super();
		this.nombre = nombre;
		this.rareza = rareza;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.pago = pago;
		this.renovacion = renovacion;
		this.imagen = imagen;
	}

}
