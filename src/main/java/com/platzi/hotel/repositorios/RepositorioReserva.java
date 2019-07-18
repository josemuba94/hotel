package com.platzi.hotel.repositorios;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.hotel.modelo.Reserva;

public interface RepositorioReserva extends JpaRepository<Reserva, Long> {

	@Query("select r from Reserva r where r.fechaInicio=:fechaInicio and r.fechaFin=:fechaFin")
	public List<Reserva> find(@Param("fechaInicio") Calendar fechaInicio, @Param("fechaFin") Calendar fechaFin);
}
