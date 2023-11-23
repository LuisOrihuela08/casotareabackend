package com.proyecto.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data



public class GetNewId {


    @Id
    private int id;
    
}
