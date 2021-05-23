package com.salesianostriana.dam.proyectofinaljaimejimenez.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Complemento;

import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.ComplementoService;
import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.PagoService;
import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.RarezaService;
import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.TipoService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Jaime Jiménez
 * 
 *         Con los controladores es como haremos que nuestra app haga lo que le
 *         pidamos, lo hará mediante enlaces que harán referencia a los
 *         distintos documentos con extensión .html que tengamos en la carpeta
 *         templates.
 *
 *
 *
 *			Para iniciar la página principal, se debe poner en el buscador:  localhost:9000/admin/complemento/
 *
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/complemento")
public class MainController {

	private final ComplementoService servicio;
	private final PagoService pagoServicio;
	private final TipoService tipoServicio;
	private final RarezaService rarezaServicio;

	@GetMapping("/")
	public String principal(Model model) {
		//Agregamos lista con todas las categorías al modelo
		model.addAttribute("complemento", servicio.findAll());
		model.addAttribute("pagos", pagoServicio.findAll());
		model.addAttribute("tipos", tipoServicio.findAll());
		model.addAttribute("rarezas", rarezaServicio.findAll());
		return "index"; //nuestro index, que tenemos en la carpeta templates
	}
	
	@GetMapping("/listado")
	public String todos(Model model) {
		model.addAttribute("complemento", servicio.findAll());
		model.addAttribute("pagos", pagoServicio.findAll());
		model.addAttribute("tipos", tipoServicio.findAll());
		model.addAttribute("rarezas", rarezaServicio.findAll());
		return "admin/list-complemento";
	}

	@GetMapping("/editar/{id}")
	public String unComplemento(@PathVariable("id") Long complementoId, Model model) {
		Complemento c = servicio.findById(complementoId).orElse(null);
		//si el complemento no es nulo, nos abrirá el formulario, si es nulo, no pasará nada
		if (c != null) {
			model.addAttribute("complemento", c);
			model.addAttribute("pagos", pagoServicio.findAll());
			model.addAttribute("tipos", tipoServicio.findAll());
			model.addAttribute("rarezas", rarezaServicio.findAll());
			return "admin/form-complemento";
		} else {
			return "redirect:/admin/complemento/";
		}

	}
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("complemento") Complemento a) {
		servicio.edit(a);
		return "redirect:/admin/complemento/listado";// Volvemos a redirigir la listado a través del controller para pintar la lista
									// actualizada con la modificación hecha
	}

	@GetMapping("/nuevo")
	public String showForm(Model model) {
		//método que abre el formulario para poner un nuevo complemento
		model.addAttribute("pagos", pagoServicio.findAll());
		model.addAttribute("tipos", tipoServicio.findAll());
		model.addAttribute("rarezas", rarezaServicio.findAll());
		model.addAttribute("complemento", new Complemento());

		return "admin/form-complemento";
	}

	@PostMapping("/nuevo/submit")
	public String processForm(@ModelAttribute("complemento") Complemento nuevo, Model model) {
		//guarda el nuevo objeto y nos lleva a la lista
		servicio.save(nuevo);

		return "redirect:/admin/complemento/";
	}

	@GetMapping("/borrar/{id}")
	public String borrarComplemento(@PathVariable("id") Long id, Model model) {
		//borrar por id
		servicio.deleteById(id);

		return "redirect:/admin/complemento/";

	}

	@GetMapping("/complemento/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		Complemento c = servicio.findById(id).orElse(null);

		//muestra la página de detalles
		if (c != null) {

			model.addAttribute("complemento", c);
			return "details";

		}
		return "redirect:/admin/complemento/";
	}

}
