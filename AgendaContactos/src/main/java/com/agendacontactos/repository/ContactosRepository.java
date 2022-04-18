package com.agendacontactos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendacontactos.entity.Contactos;

@Repository
public interface ContactosRepository extends JpaRepository<Contactos, Integer>{

}
