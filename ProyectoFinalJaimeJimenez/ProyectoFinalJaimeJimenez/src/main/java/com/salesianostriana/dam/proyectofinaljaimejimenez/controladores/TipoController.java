package com.salesianostriana.dam.proyectofinaljaimejimenez.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Tipo;
import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.TipoService;

/**
 * 
 * @author Jaime Jiménez
 * 
 *         Las funcionalidades son las mismas que en el MainController
 *
 */

@Controller
@RequestMapping("/tipo")
public class TipoController {

	@Autowired
	private TipoService tipoService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("tipos", tipoService.findAll());
		return "admin/list-tipo";
	}

	@GetMapping("/nuevo")
	public String nuevoTipo(Model model) {
		model.addAttribute("tipo", new Tipo());
		return "admin/form-tipo";
	}

	@PostMapping("/nuevo/submit")
	public String submitNuevoTipo(@ModelAttribute("tipo") Tipo nuevo, Model model) {

		tipoService.save(nuevo);

		return "redirect:/tipo/";

	}

	@GetMapping("/editar/{id}")
	public String editarTipo(@PathVariable("id") Long id, Model model) {

		Tipo tipo = tipoService.findById(id).orElse(null);

		if (tipo != null) {
			model.addAttribute("tipo", tipo);
			return "admin/form-tipo";
		} else {
			return "redirect:/tipo/";
		}

	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("tipo") Tipo a) {
		tipoService.edit(a);
		return "redirect:/tipo/";
	}

	@GetMapping("/borrar/{id}")
	public String borrarTipo(@PathVariable("id") Long id, Model model) {

		tipoService.deleteById(id);

		return "redirect:/tipo/";
	}

}
