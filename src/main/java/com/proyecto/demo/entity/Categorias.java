package com.proyecto.demo.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Categoria")

public class Categorias {

    @Id
    @Column(name = "ID_CATEGORIA")
    private int ID_CATEGORIA;

    @Column(name = "CATEGORIA")
    private String CATEGORIA;

    @JsonIgnore
    @OneToMany(mappedBy= "categoria")
    private List <Libros> libro;
    
    public Categorias(int id) {
        this.ID_CATEGORIA = id;
    }
    
}
