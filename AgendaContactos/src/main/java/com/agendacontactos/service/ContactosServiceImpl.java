package com.agendacontactos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendacontactos.entity.Contactos;
import com.agendacontactos.repository.ContactosRepository;

@Service
public class ContactosServiceImpl implements ContactosService {

	@Autowired
	public ContactosRepository repository;

	@Override
	public List<Contactos> listaContactos() {
		return repository.findAll();
	}

	@Override
	public Contactos guardarContacto(Contactos contactos) {
		return repository.save(contactos);
	}

	@Override
	public Contactos obtenerContactoId(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public Contactos actualizarContacto(Contactos contactos) {
		return repository.save(contactos);
	}

	@Override
	public void eliminarContacto(Integer id) {
		repository.deleteById(id);
	}

}
