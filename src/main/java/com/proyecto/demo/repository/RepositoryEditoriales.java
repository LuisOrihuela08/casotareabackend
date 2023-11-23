package com.proyecto.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.Editoriales;

@Repository("editorialesRepository")
public interface RepositoryEditoriales extends CrudRepository<Editoriales, String> {

}
