package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entity.Libros;
import com.proyecto.demo.repository.RepositoryGetNewId;
import com.proyecto.demo.repository.RepositoryLibros;
import com.proyecto.demo.service.ServiceLibros;

import jakarta.transaction.Transactional;

@Service("librosServiceImpl")
@Transactional

public class ServiceimplLibros implements ServiceLibros {

	@Autowired
	@Qualifier("librosRepository")
	private RepositoryLibros repositoryLibros;

	@Autowired
	@Qualifier("getNewIdRepository")
	private RepositoryGetNewId RepoId;

	public List<Libros> listAllLibros() {

		return (List<Libros>) repositoryLibros.findAll();
	}

	public Optional<Libros> findByIdLibros(String id) {

		return repositoryLibros.findById(id);
	}

	public Libros updateLibros(Libros libros) {

		return repositoryLibros.save(libros);
	}

	public int removeLibros(String id) {

		repositoryLibros.deleteById(id);
		return 0;

	}

	public Libros addLibros(Libros libros) {

		int id = RepoId.getID().getId();

		Libros new_ = new Libros();
		new_.setID_LIBRO(id);
		
		new_.setTITULO(libros.getTITULO());
		new_.setFECHA_LANZAMIENTO(libros.getFECHA_LANZAMIENTO());
		new_.setIDIOMA(libros.getIDIOMA());
		new_.setPAGINAS(libros.getPAGINAS());
		new_.setDESCRIPCION(libros.getDESCRIPCION());
		new_.setPORTADA(libros.getPORTADA());
		new_.setAutor(libros.getAutor());
		new_.setCategoria(libros.getCategoria());
		new_.setEditorial(libros.getEditorial());
		return repositoryLibros.save(new_);

	}

}
