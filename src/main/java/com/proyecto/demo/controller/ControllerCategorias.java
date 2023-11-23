package com.proyecto.demo.controller;
import com.proyecto.demo.entity.Categorias;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.service.impl.ServiceimplCategorias;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins="*")
public class ControllerCategorias {

	@Autowired
	@Qualifier("cateogirasServiceImpl")
	private ServiceimplCategorias categoriasService;
	
	@GetMapping(path="/list", produces= {"application/json"})
	public List<Categorias> listCategorias(){
		return categoriasService.listAllCategorias();
	}
	
	@GetMapping(path="/get/{id}", produces= {"application/json"})
	public Optional<Categorias> getCategorias (@PathVariable String id){
		return categoriasService.findByIdCategorias(id);
	}
	
	@PutMapping(path="/editar", produces= {"application/json"})
	public Categorias updCategorias(@RequestBody Categorias categorias) {
		return categoriasService.updateCategorias(categorias);
	}
	
	@DeleteMapping(path="/eliminar/{id}")
	public int delCategorias(@PathVariable String id) {
		return categoriasService.removeCategorias(id);
	}
	
	@PostMapping(path="/agregar", produces= {"application/json"})
	public Categorias newCategorias(@RequestBody Categorias categorias) {
		return categoriasService.addCategorias(categorias);
	}
}
