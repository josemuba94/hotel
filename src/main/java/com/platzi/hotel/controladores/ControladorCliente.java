package com.platzi.hotel.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.hotel.dtos.ClienteDto;
import com.platzi.hotel.modelo.Cliente;
import com.platzi.hotel.servicios.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/hotel")
@Api(tags = "cliente")
public class ControladorCliente {

	private ClienteService clienteService;

	public ControladorCliente(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	@ApiOperation(value = "Crear cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida") })
	public ResponseEntity<Cliente> crearCliente(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(clienteDto.getIdCliente());
		cliente.setNombre(clienteDto.getNombre());
		cliente.setApellido(clienteDto.getApellido());
		cliente.setFechaNacimiento(clienteDto.getFechaNacimiento());
		cliente.setIdentificacion(clienteDto.getIdentificacion());

		return new ResponseEntity<>(clienteService.guardarCliente(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{identificacion}")
	@ApiOperation(value = "Actualizar cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable("identificacion") String identificacion,
			@RequestBody ClienteDto clienteDto) {
		Cliente cliente = clienteService.findByIdentificacion(identificacion);

		if (cliente == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			cliente.setIdCliente(clienteDto.getIdCliente());
			cliente.setNombre(clienteDto.getNombre());
			cliente.setApellido(clienteDto.getApellido());
			cliente.setFechaNacimiento(clienteDto.getFechaNacimiento());
			cliente.setIdentificacion(clienteDto.getIdentificacion());
		}

		return new ResponseEntity<>(clienteService.guardarCliente(cliente), HttpStatus.OK);
	}

	@DeleteMapping("/{identificacion}")
	@ApiOperation(value = "Eliminar cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public void eliminarcliente(@PathVariable("identificacion") String identificacion) {
		Cliente cliente = clienteService.findByIdentificacion(identificacion);

		if (cliente != null)
			clienteService.eliminarCliente(cliente);
	}

	@GetMapping
	@ApiOperation(value = "Listar clientes", notes = "Servicio para listar los clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Clientes listados correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrados") })
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(clienteService.obtenerClientes());
	}
}
