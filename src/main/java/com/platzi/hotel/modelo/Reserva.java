package com.platzi.hotel.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private Long idReserva;
	@Temporal(value = TemporalType.DATE)
	private Calendar fechaInicio;
	@Temporal(value = TemporalType.DATE)
	private Calendar fechaFin;
	private int cantidadPersonas;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
}
