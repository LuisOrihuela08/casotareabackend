package com.proyecto.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.entity.Editoriales;
import com.proyecto.demo.service.impl.ServiceimplEditoriales;

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

@RestController
@RequestMapping("/editoriales")
@CrossOrigin(origins ="*")
public class ControllerEditoriales {

	@Autowired
	@Qualifier("editorialesServiceImpl")
	private ServiceimplEditoriales editorialesService;
	
	@GetMapping(path="/list", produces = {"application/json"})
	public List<Editoriales> listEditoriales(){
		return editorialesService.listAllEditoriales();
	}
	
	@GetMapping(path="/get/{id}", produces = {"application/json"})
	public Optional<Editoriales> getEditoriales(@PathVariable String id){
		return editorialesService.findByIdEditoriales(id);
		}
	
	@PutMapping(path="/editar", produces = {"application/json"})
	public Editoriales updEditoriales(@RequestBody Editoriales editoriales) {
		return editorialesService.updateEditoriales(editoriales);
	}
	
	@DeleteMapping(path="/eliminar/{id}")
	public int delEditoriales (@PathVariable String id) {
		return editorialesService.removeEditoriales(id);
	}
	
	@PostMapping(path="/agregar", produces = {"application/json"})
	public Editoriales newEditoriales(@RequestBody Editoriales editoriales) {
		return editorialesService.addEditoriales(editoriales);
	}
}
