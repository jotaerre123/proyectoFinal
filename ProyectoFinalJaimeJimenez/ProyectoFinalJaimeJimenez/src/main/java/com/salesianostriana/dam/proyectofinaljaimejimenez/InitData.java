package com.salesianostriana.dam.proyectofinaljaimejimenez;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Complemento;
import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Pago;
import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Rareza;
import com.salesianostriana.dam.proyectofinaljaimejimenez.modelo.Tipo;
import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.ComplementoService;
import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.PagoService;
import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.RarezaService;
import com.salesianostriana.dam.proyectofinaljaimejimenez.servicios.TipoService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Jaime Jiménez
 * 
 * Clase Init Data: sirve para empezar la app con algunos objetos ya definidos en la base de datos
 * 
 *
 */

@Component
@RequiredArgsConstructor
public class InitData {

	private final ComplementoService complementoServicio;
	private final PagoService pagoServicio;
	private final TipoService tipoServicio;
	private final RarezaService rarezaServicio;

	/**
	 * Listado de objetos que se guardarán a la base de datos, un listado por cada clase anotada con @Entity que tengamos en el paquete
	 * 'modelo'. Cada listado vendrá seguido por un for each, que es el que se encargará de guardar todos los elementos de la lista.
	 */
	
	@PostConstruct
	public void init() {

		List<Pago> guardarPagos = List.of(new Pago("Plata", 1250), new Pago("Polvo Luminoso", 6000));

		for (Pago pago : guardarPagos) {
			pagoServicio.save(pago);
		}

		List<Tipo> guardarTipos = List.of(new Tipo("Vehículo"), new Tipo("Gesto"), new Tipo("Diseño de Arma"),
				new Tipo("Shader"));

		for (Tipo tipo : guardarTipos) {
			tipoServicio.save(tipo);
		}

		List<Rareza> guardarRarezas = List.of(new Rareza("Excepcional"), new Rareza("Legendario"));

		for (Rareza rareza : guardarRarezas) {
			rarezaServicio.save(rareza);
		}

		/**
		 * Para el listado de la entidad principal, será importante iniciar la base de datos de h2 con el siguiente enlace: localhost:9000/h2-console,
		 * para ver el ID que se le asignara al metodo findById(). Por ejemplo 7L corresponderia a la rareza llamada 'Excepcional', y el añadido de 'L' 
		 * es porque las ID son Long.
		 */
		
		List<Complemento> guardarComplementos = List
				.of(new Complemento("THE UNTOLD TALE", rarezaServicio.findById(7L).get(),
						"Equip this weapon ornament to change the appearance of Vex Mythoclast."
								+ " Once you get an ornament," + " it's unlocked for all characters on your account.",
						tipoServicio.findById(5L).get(), pagoServicio.findById(2L).get(), LocalDate.now(), "https://www.bungie.net/common/destiny2_content/icons/c457d8b3f30a02b4b5118bc4bd421485.jpg"),
						new Complemento("ATROPOS", rarezaServicio.findById(7L).get(), "Calibrate reality. Seek inevitability. Embody divinity.",
								tipoServicio.findById(5L).get(), pagoServicio.findById(1L).get(), LocalDate.now(), "https://www.bungie.net/common/destiny2_content/icons/5b5af31d2518768aacafe2a3e441356b.jpg"),
						new Complemento("LUXURIOUS TOAST", rarezaServicio.findById(7L).get(),"Life's good when you make friends.",
								tipoServicio.findById(4L).get(), pagoServicio.findById(1L).get(), LocalDate.now(), "https://www.bungie.net/common/destiny2_content/icons/e504270438a5d6530598d17ffec990fe.jpg"),
						new Complemento("SAINT-14'S GRAY PIGEON", rarezaServicio.findById(7L).get(),
								"'The name? Pigeons are the only birds left in the City sky. One of the many 'last things' we fight for. If you have a problem with that, we could step into the Crucible.' —Saint-14",
								tipoServicio.findById(3L).get(), pagoServicio.findById(1L).get(), LocalDate.now(), "https://www.bungie.net/common/destiny2_content/icons/53c88996fd41581a32bdb81c70f2b5fe.jpg"),
						new Complemento("CALUS'S TREASURED", rarezaServicio.findById(8L).get(), "Apply this shader to change the color of your gear.",
								tipoServicio.findById(6L).get(), pagoServicio.findById(2L).get(), LocalDate.now(), "https://www.bungie.net/common/destiny2_content/icons/d285211f8777f6276e7d2d508906bacf.jpg")

				);

		for (Complemento c : guardarComplementos) {
			complementoServicio.save(c);
		}

	}

}
