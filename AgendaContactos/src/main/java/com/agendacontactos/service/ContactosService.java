package com.agendacontactos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agendacontactos.entity.Contactos;

@Service
public interface ContactosService {

	public List<Contactos> listaContactos();

	public Contactos guardarContacto(Contactos contactos);

	public Contactos obtenerContactoId(Integer id);

	public Contactos actualizarContacto(Contactos contactos);

	public void eliminarContacto(Integer id);
}
