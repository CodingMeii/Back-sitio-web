/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Client;
import com.rentcloud.cloud.app.entities.Cloud;
import com.rentcloud.cloud.app.repositories.crud.CloudCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RYZEN
 */
@Repository
public class CloudRepository {
    @Autowired
    private CloudCrudRepository repository;
    
    /*
    Select * from
    @return retorna todos los registro de la tabla
    */
    public List<Cloud> getAll(){
        return (List<Cloud>) repository.findAll();
    }
    
    /*
    Select * from table where ID=id
    @param id
    @return retorna un registro por el ID
    */
    public Optional<Cloud> getCloud(int id){
        return repository.findById(id);
    }
    
    /*
    insert & update
    @param admin
    @return actualiza registro ya existente o crea un nuevo registro
    */
    public Cloud save (Cloud cloud){
        return repository.save(cloud);
    }
    
    /*
    Delete from table
    @param admin
    */
    public void delete (Cloud cloud){
        repository.delete(cloud);
    }
}
