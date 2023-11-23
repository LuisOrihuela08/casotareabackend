package com.proyecto.demo.controller;

import com.proyecto.demo.entity.Autores;

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

import com.proyecto.demo.service.impl.ServiceimplAutores;

@RestController
@RequestMapping("/autores")
@CrossOrigin(origins="*")
public class ControllerAutores {

	@Autowired
	@Qualifier("autoresServiceImpl")
	private ServiceimplAutores autoresService;
	
	@GetMapping(path="/list", produces = {"application/json"})
	public List<Autores> listAutores(){
		return autoresService.listAllAutores();
	}
	
	@GetMapping(path="/get/{id}",produces = {"application/json"})
	public Optional<Autores> getAutores(@PathVariable String id){
		return autoresService.findByIdAutores(id);
	}
	
	@PutMapping(path="/editar",produces = {"application/json"})
	public Autores updAutores(@RequestBody Autores autores) {
		return autoresService.updateAutores(autores);
	}
	
	@DeleteMapping(path="/eliminar/{id}")
	public int delAutores(@PathVariable String id) {
		return autoresService.removeAutores(id);
	}
	
	@PostMapping(path="/agregar", produces = {"application/json"})
	public Autores newAutores(@RequestBody Autores autores) {
		return autoresService.addAutores(autores);
	}
}
