package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entity.Editoriales;
import com.proyecto.demo.repository.RepositoryEditoriales;
import com.proyecto.demo.repository.RepositoryGetNewId;
import com.proyecto.demo.service.ServiceEditoriales;

import jakarta.transaction.Transactional;

@Service("editorialesServiceImpl")
@Transactional
public class ServiceimplEditoriales implements ServiceEditoriales {

	@Autowired
	@Qualifier("editorialesRepository")
	private RepositoryEditoriales repositoryEditoriales;

	@Autowired
	@Qualifier("getNewIdRepository")
	private RepositoryGetNewId RepoId;

	public List<Editoriales> listAllEditoriales(){
		return(List<Editoriales>)repositoryEditoriales.findAll();
	}

	@Override
	public Optional<Editoriales> findByIdEditoriales(String id) {
		// TODO Auto-generated method stub
		return repositoryEditoriales.findById(id);
	}

	@Override
	public Editoriales updateEditoriales(Editoriales editoriales) {
		// TODO Auto-generated method stub
		return repositoryEditoriales.save(editoriales);
	}

	@Override
	public int removeEditoriales(String id) {
		// TODO Auto-generated method stub
		repositoryEditoriales.deleteById(id);
		return 0;
	}

	@Override
	public Editoriales addEditoriales(Editoriales editoriales) {
		
		int id = RepoId.getID().getId();
		Editoriales new_ = new Editoriales();
		new_.setID_EDITORIAL(id);
		new_.setEDITORIAL(editoriales.getEDITORIAL());
		return repositoryEditoriales.save(new_);
	}
}
