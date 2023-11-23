package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entity.Autores;
import com.proyecto.demo.repository.RepositoryAutores;
import com.proyecto.demo.repository.RepositoryGetNewId;
import com.proyecto.demo.service.ServiceAutores;

import jakarta.transaction.Transactional;

@Service("autoresServiceImpl")
@Transactional
public class ServiceimplAutores implements ServiceAutores {

	@Autowired
	@Qualifier("autoresRepository")
	private RepositoryAutores repositoryAutores;
	
	@Autowired
	@Qualifier("getNewIdRepository")
	private RepositoryGetNewId RepoId;
	
	@Override
	public List<Autores> listAllAutores() {
		// TODO Auto-generated method stub
		return (List<Autores>) repositoryAutores.findAll();
	}

	@Override
	public Optional<Autores> findByIdAutores(String id) {
		// TODO Auto-generated method stub
		return repositoryAutores.findById(id);
	}

	@Override
	public Autores updateAutores(Autores autores) {
		// TODO Auto-generated method stub
		return repositoryAutores.save(autores);
	}

	@Override
	public int removeAutores(String id) {
		// TODO Auto-generated method stub
		repositoryAutores.deleteById(id);
		return 0;
	}

	@Override
	public Autores addAutores(Autores autores) {
		// TODO Auto-generated method stub
		int id = RepoId.getID().getId();
		Autores new_ = new Autores();
		new_.setID_AUTOR(id);
		new_.setAUTOR(autores.getAUTOR());
		return repositoryAutores.save(new_);
	}

}
