package com.proyecto.demo.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.demo.entity.Editoriales;

public interface ServiceEditoriales {

	public abstract List<Editoriales> listAllEditoriales();
	public abstract Optional<Editoriales> findByIdEditoriales(String id);
	public abstract Editoriales updateEditoriales(Editoriales editoriales);
	public abstract int removeEditoriales(String id);
	public abstract Editoriales addEditoriales(Editoriales editoriales);
}
