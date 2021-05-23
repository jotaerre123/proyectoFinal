package com.salesianostriana.dam.proyectofinaljaimejimenez.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Complemento;
import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Tipo;
import com.salesianostriana.dam.proyectofinaljaimejimenez.repositorio.ComplementoRepository;
import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.base.BaseService;

@Service
public class ComplementoService extends BaseService<Complemento, Long, ComplementoRepository>{

	@Autowired
	 private ComplementoRepository repositorio;
	
	public int numeroComplementosTipo(Tipo tipo) {
		return repositorio.findNumComplementosByTipo(tipo);
	}

	
	
}
