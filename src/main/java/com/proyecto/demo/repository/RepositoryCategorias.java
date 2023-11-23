package com.proyecto.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Categorias;

@Repository("categoriasRepository")
public interface RepositoryCategorias extends CrudRepository<Categorias, String>{

}
