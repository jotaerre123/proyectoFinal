package com.salesianostriana.dam.proyectofinaljaimejimenez;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Complemento;
import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.ComplementoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	@Autowired
	private ComplementoService servicio;
	
	@PostConstruct
	public void init() {
		Complemento a = new Complemento("Vacío Infinito", "Diseño de arma", "Exótico", "Diseño de Mil Voces", "Polvo Luminoso", 1250);
		
		servicio.save(a);
	}
	
}
