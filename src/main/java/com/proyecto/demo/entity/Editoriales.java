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
@Table(name = "EDITORIAL")
public class Editoriales {
	
    @Id
    @Column(name = "ID_EDITORIAL")
    private int ID_EDITORIAL;

    @Column(name="EDITORIAL")
    private String EDITORIAL;

    @JsonIgnore
    @OneToMany(mappedBy="editorial")
    private List <Libros> libro;
    
    public Editoriales (int id) {
        this.ID_EDITORIAL = id;
    }
}
