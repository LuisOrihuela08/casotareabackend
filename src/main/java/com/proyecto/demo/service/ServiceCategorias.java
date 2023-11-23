package com.proyecto.demo.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.demo.entity.Categorias;

public interface ServiceCategorias {

	public abstract List<Categorias> listAllCategorias();
	public abstract Optional<Categorias> findByIdCategorias(String id);
	public abstract Categorias updateCategorias (Categorias categorias);
	public abstract int removeCategorias (String id);
	public abstract Categorias addCategorias (Categorias categorias);
	
}
