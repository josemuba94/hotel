package com.platzi.hotel.dtos;

import java.util.Calendar;
import java.util.List;

import com.platzi.hotel.modelo.Reserva;

import lombok.Data;

@Data
public class ClienteDto {

	private Long idCliente;
	private String nombre;
	private String apellido;
	private String identificacion;
	private Calendar fechaNacimiento;
	private List<Reserva> reservas;
}
