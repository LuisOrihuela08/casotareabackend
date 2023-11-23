package com.proyecto.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entity.Categorias;
import com.proyecto.demo.repository.RepositoryCategorias;
import com.proyecto.demo.repository.RepositoryGetNewId;
import com.proyecto.demo.service.ServiceCategorias;

import jakarta.transaction.Transactional;

@Service("cateogirasServiceImpl")
@Transactional
public class ServiceimplCategorias implements ServiceCategorias{

	@Autowired
	@Qualifier("categoriasRepository")
	private RepositoryCategorias repositoryCategorias;
	
	@Autowired
	@Qualifier("getNewIdRepository")
	private RepositoryGetNewId RepoId;
	
	@Override
	public List<Categorias> listAllCategorias() {
		// TODO Auto-generated method stub
		return (List<Categorias>) repositoryCategorias.findAll();
	}

	@Override
	public Optional<Categorias> findByIdCategorias(String id) {
		// TODO Auto-generated method stub
		return repositoryCategorias.findById(id);
	}

	@Override
	public Categorias updateCategorias(Categorias categorias) {
		// TODO Auto-generated method stub
		return repositoryCategorias.save(categorias);
	}

	@Override
	public int removeCategorias(String id) {
		// TODO Auto-generated method stub
		repositoryCategorias.deleteById(id);
		return 0;
	}

	@Override
	public Categorias addCategorias(Categorias categorias) {
		// TODO Auto-generated method stub
		int id = RepoId.getID().getId();
		Categorias new_ = new Categorias();
		new_.setID_CATEGORIA(id);
		new_.setCATEGORIA(categorias.getCATEGORIA());
		return repositoryCategorias.save(new_);
	}

}
