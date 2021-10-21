/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.services;

import com.rentcloud.cloud.app.entities.Message;
import com.rentcloud.cloud.app.repositories.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RYZEN
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;
    
    /*
    GET
    @return Lista de admin
    */
    public List<Message> getAll(){
        return repository.getAll();
    }
    
    /*
    GET/{id}
    @param adminId
    @return
    */
    public Optional<Message> getMessage(int messageId){
        return repository.getMessage(messageId);
    }
    
    /*
    POST
    @param admin
    @return
    */
    public Message save(Message message){
        //consultar si se envia el ID
        if(message.getIdMessage()==null){
            return repository.save(message);
        }else{
            //consultar si existe el registro
            Optional<Message> existMessage = repository.getMessage(message.getIdMessage());
            
            if(existMessage.isPresent()){
                return message;
            }else{
                return repository.save(message);
            }
        }
    }
    
    /*
    UPDATE
    @param admin
    @return
    */
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> existMessage = repository.getMessage(message.getIdMessage());
            
            if(existMessage.isPresent()){
                if(message.getMessageText()!=null){
                    existMessage.get().setMessageText(message.getMessageText());
                }
                
                return repository.save(existMessage.get());
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    
    /*
    DELETE
    @param adminId
    @return
    */
    public boolean delete(int messageId){
        Boolean respuesta = getMessage(messageId).map(message -> {
            repository.delete(message);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
