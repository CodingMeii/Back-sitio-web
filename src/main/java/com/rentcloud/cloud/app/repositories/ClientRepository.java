/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Client;
import com.rentcloud.cloud.app.repositories.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RYZEN
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository repository;
    
    /*
    Select * from
    @return retorna todos los registro de la tabla
    */
    public List<Client> getAll(){
        return (List<Client>) repository.findAll();
    }
    
    /*
    Select * from table where ID=id
    @param id
    @return retorna un registro por el ID
    */
    public Optional<Client> getClient(int id){
        return repository.findById(id);
    }
    
    /*
    insert & update
    @param admin
    @return actualiza registro ya existente o crea un nuevo registro
    */
    public Client save (Client client){
        return repository.save(client);
    }
    
    /*
    Delete from table
    @param admin
    */
    public void delete (Client client){
        repository.delete(client);
    }
}
