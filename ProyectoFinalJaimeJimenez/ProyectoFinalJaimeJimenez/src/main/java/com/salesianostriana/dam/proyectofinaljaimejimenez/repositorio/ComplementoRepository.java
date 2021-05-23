package com.salesianostriana.dam.proyectofinaljaimejimenez.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Complemento;
import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Tipo;

public interface ComplementoRepository extends JpaRepository<Complemento, Long>{

	@Query("select count(p) from Complemento p where p.tipo = ?1")
	public int findNumComplementosByTipo(Tipo tipo);
	
}
