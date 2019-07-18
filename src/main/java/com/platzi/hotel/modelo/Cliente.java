package com.platzi.hotel.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findByIdentificacion", query = "select c from Cliente c where c.identificacion = ?1")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private Long idCliente;
	private String nombre;
	private String apellido;
	private String identificacion;
	@Temporal(value = TemporalType.DATE)
	private Calendar fechaNacimiento;
	@OneToMany(mappedBy = "cliente")
	private List<Reserva> reservas;
}
