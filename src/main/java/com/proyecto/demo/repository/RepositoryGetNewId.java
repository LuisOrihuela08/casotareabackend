package com.proyecto.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.demo.entity.GetNewId;

@Repository("getNewIdRepository")

public interface RepositoryGetNewId extends CrudRepository <GetNewId, String> {

        
        @Query(value = "SELECT MI_SECUENCIA.NEXTVAL as id FROM DUAL", nativeQuery = true)
            GetNewId getID();


    
}
