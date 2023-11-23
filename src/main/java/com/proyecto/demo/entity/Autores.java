package com.proyecto.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Autores")
public class Autores {

	@Id
	@Column(name = "ID_AUTOR")
	private int ID_AUTOR;

	@Column(name = "AUTOR")
	private String AUTOR;

	@JsonIgnore
	@OneToMany(mappedBy = "autor")
	private List<Libros> libro;
	
	public Autores(int id) {
        this.ID_AUTOR = id;
    }

}
