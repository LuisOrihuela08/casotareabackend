package com.proyecto.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LIBROS")
public class Libros {

	@Id
	@Column(name = "ID_LIBRO")
	private int ID_LIBRO;

	@Column(name = "TITULO")
	private String TITULO;

	@Column(name = "FECHA_LANZAMIENTO")
	private String FECHA_LANZAMIENTO;

	@Column(name = "IDIOMA")
	private String IDIOMA;

	@Column(name = "PAGINAS")
	private int PAGINAS;

	@Column(name = "PORTADA")
	private String PORTADA;

	@Column(name = "DESCRIPCION")
	private String DESCRIPCION;

	@JsonIgnore
	@OneToMany(mappedBy = "libro")
	private List<Alquiler> alquileres;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_autor")
	private Autores autor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categoria")
	private Categorias categoria;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_editorial")
	private Editoriales editorial;
}
