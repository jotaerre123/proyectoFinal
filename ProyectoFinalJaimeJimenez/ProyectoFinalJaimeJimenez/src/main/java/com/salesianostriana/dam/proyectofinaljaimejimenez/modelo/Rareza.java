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
public class Rareza {

	@Id
	@GeneratedValue
	private long id;

	private String rareza;

	public Rareza(String rareza) {
		super();
		this.rareza = rareza;
	}

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "rareza", fetch = FetchType.EAGER)
	private List<Complemento> complementos = new ArrayList<>();
	
	//HELPERS

	public void addComplemento(Complemento p) {
		this.complementos.add(p);
		p.setRareza(this);
	}

	public void removeRareza(Complemento p) {
		this.complementos.remove(p);
		p.setRareza(null);
	}

}
