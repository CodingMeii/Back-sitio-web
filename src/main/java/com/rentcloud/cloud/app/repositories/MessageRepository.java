/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Cloud;
import com.rentcloud.cloud.app.entities.Message;
import com.rentcloud.cloud.app.repositories.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RYZEN
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository repository;
    
    /*
    Select * from
    @return retorna todos los registro de la tabla
    */
    public List<Message> getAll(){
        return (List<Message>) repository.findAll();
    }
    
    /*
    Select * from table where ID=id
    @param id
    @return retorna un registro por el ID
    */
    public Optional<Message> getMessage(int id){
        return repository.findById(id);
    }
    
    /*
    insert & update
    @param admin
    @return actualiza registro ya existente o crea un nuevo registro
    */
    public Message save (Message message){
        return repository.save(message);
    }
    
    /*
    Delete from table
    @param admin
    */
    public void delete (Message message){
        repository.delete(message);
    }
}
