package com.salesianostriana.dam.proyectofinaljaimejimenez.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pago {

	@Id
	@GeneratedValue
	private long id;

	private String moneda; // plata o polvo luminoso
	private int precio;

	public Pago(String moneda, int precio) {
		super();
		this.moneda = moneda;
		this.precio = precio;
	}

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "pago", fetch = FetchType.EAGER)
	private List<Complemento> complementos = new ArrayList<>();
	
	//HELPERS

	public void addComplemento(Complemento p) {
		this.complementos.add(p);
		p.setPago(this);
	}

	public void removePago(Complemento p) {
		this.complementos.remove(p);
		p.setPago(null);
	}

}
