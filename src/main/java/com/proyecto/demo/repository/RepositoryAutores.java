package com.proyecto.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Autores;

@Repository("autoresRepository")
public interface RepositoryAutores extends CrudRepository<Autores, String>{

}
