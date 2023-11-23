package com.proyecto.demo.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.demo.entity.Autores;

public interface ServiceAutores {

	public abstract List<Autores> listAllAutores();
	public abstract Optional<Autores> findByIdAutores(String id);
	public abstract Autores updateAutores(Autores autores);
	public abstract int removeAutores(String id);
	public abstract Autores addAutores(Autores autores);
	
}
