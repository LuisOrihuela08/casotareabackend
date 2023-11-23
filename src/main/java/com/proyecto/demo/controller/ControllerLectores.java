package com.proyecto.demo.controller;
import com.proyecto.demo.entity.Lectores;


import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.service.impl.ServiceimplLectores;

@RestController
@RequestMapping("/lectores")
@CrossOrigin(origins = "*")


public class ControllerLectores {

        @Autowired
        @Qualifier("lectoresServiceImpl")

        private ServiceimplLectores lectoresService;


        @GetMapping(path="/list", produces = {"application/json"})
        public List<Lectores> listLectores(){

            return lectoresService.listAllLectores();

        }

         @GetMapping(path="/get/{id}", produces = {"application/json"})
        public Optional<Lectores> getLectores(@PathVariable String id){

            return lectoresService.findByIdLectores(id);

        }

         @PutMapping(path="/editar", produces = {"application/json"})
        public Lectores updLibros(@RequestBody Lectores lectores ){

            return lectoresService.updateLectores(lectores);

        }

        @DeleteMapping(path="/eliminar/{id}")
        public int delLectores(@PathVariable String id ){

            return lectoresService.removeLectores(id);

        }


        @PostMapping(path="/agregar", produces = {"application/json"})
        public Lectores newLectores(@RequestBody Lectores lectores ){

            return lectoresService.addLectores(lectores);

        }






    
}
