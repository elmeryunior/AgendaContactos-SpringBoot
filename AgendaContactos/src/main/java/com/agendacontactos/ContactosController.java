package com.agendacontactos;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agendacontactos.entity.Contactos;
import com.agendacontactos.service.ContactosService;

@Controller
public class ContactosController {

	@Autowired
	ContactosService service;

	@GetMapping({ "/contactos", "/" })
	public String listarContactos(Model model) {
		model.addAttribute("contactos", service.listaContactos());
		return "contactos";
	}

	@GetMapping("/contactos/nuevo")
	public String nuevoContactoForm(Model model) {
		Contactos contactos = new Contactos();
		model.addAttribute("contacto", contactos);
		return "nuevo_contacto";
	}

	@PostMapping("/contactos")
	public String guardarContacto(@Validated @ModelAttribute("contacto") Contactos contacto,
			BindingResult bindingResult, RedirectAttributes attributes, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("contacto", contacto);
			return "nuevo_contacto";
		}
		service.guardarContacto(contacto);
		attributes.addFlashAttribute("msgExito", "El contacto fue agregado con éxito");
		return "redirect:/contactos";
	}

	@GetMapping("/contactos/editar/{id}")
	public String editarContactoForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("contacto", service.obtenerContactoId(id));
		return "editar_contacto";
	}

	@PostMapping("/contactos/{id}")
	public String actualizarContacto(@PathVariable("id") Integer id,
			@Validated @ModelAttribute("contacto") Contactos contacto, BindingResult result, Model model) {
		Contactos contactoExist = service.obtenerContactoId(id);

		if (result.hasErrors()) {
			model.addAttribute("contacto", contacto);
			return "editar_contacto";
		}

		contactoExist.setId(id);
		contactoExist.setNombre(contacto.getNombre());
		contactoExist.setCelular(contacto.getCelular());
		contactoExist.setEmail(contacto.getEmail());
		contactoExist.setFechaNacimiento(contacto.getFechaNacimiento());
		contactoExist.setFechaReg(contactoExist.getFechaReg());

		service.guardarContacto(contactoExist);
		return "redirect:/contactos";
	}

	@GetMapping("/contactos/{id}")
	public String eliminarContacto(@PathVariable("id") Integer id) {
		service.eliminarContacto(id);
		return "redirect:/contactos";
	}

}
