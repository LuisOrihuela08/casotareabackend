package com.proyecto.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Lectores")
public class Lectores {
	@Id
	@Column(name = "DNILector")
	
	private int DNILector;

	@Column(name = "Nombre")
	private String Nombre;

	@Column(name = "Telefono")
	private int Telefono;

	@Column(name = "Direccion")
	private String Direccion;

	@Column(name = "CODIGOPOSTAL")
	private String CODIGOPOSTAL;

	@Column(name = "Observaciones")
	private String Observaciones;

//   @JsonIgnoreProperties("lector")
// @OneToMany(mappedBy = "lector", cascade = CascadeType.ALL, orphanRemoval = true)
// private List<Alquiler> alquileres;

	@JsonIgnore
	@OneToMany(mappedBy = "lector")
	private List<Alquiler> alquileres;

}
