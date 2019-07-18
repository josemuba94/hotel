package com.platzi.hotel.servicios;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.hotel.modelo.Cliente;
import com.platzi.hotel.repositorios.RepositorioCliente;

@Service
@Transactional
public class ClienteService {

	private RepositorioCliente repositorioCliente;

	public ClienteService(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public Cliente guardarCliente(Cliente cliente) {
		return repositorioCliente.save(cliente);
	}
	
	public void eliminarCliente(Cliente cliente) {
		repositorioCliente.delete(cliente);
	}
	
	public Cliente findByIdentificacion(String identificacion) {
		return repositorioCliente.findByIdentificacion(identificacion);
	}
	
	public List<Cliente> obtenerClientes(){
		return repositorioCliente.findAll();
	}
}
