package com.platzi.hotel.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.hotel.modelo.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente, Long> {

	/* Genera la consulta automáticamente si se cumple con la sintaxis, para buscar por más
	 de un parámetro, se concatena con And [findByApellidoAnNombreAnd...] */
	public Cliente findByApellido(String apellido);
	
	// Está enlazada con el nombre del NamedQuery de la clase Cliente
	public Cliente findByIdentificacion(String identificacion);
	
}
