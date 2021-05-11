package com.salesianostriana.dam.proyectofinaljaimejimenez.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.ComplementoService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class ComplementoController {

	@Autowired
	private ComplementoService servicio;
	
	@GetMapping("/complemento")
	public String todosLosComplementos(Model model) {
		model.addAttribute("complementos", servicio.findAll());
		return "prueba";
	}
	
	@GetMapping("/complemento/{id}")
	public String unComplemento(@PathVariable("id") Long complementoId,Model model) {
		model.addAttribute("complemento", servicio.findById(complementoId));
		return "detail";
	}
	
}
