/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Reservation;
import com.rentcloud.cloud.app.repositories.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RYZEN
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository repository;
    
    /*
    Select * from
    @return retorna todos los registro de la tabla
    */
    public List<Reservation> getAll(){
        return (List<Reservation>) repository.findAll();
    }
    
    /*
    Select * from table where ID=id
    @param id
    @return retorna un registro por el ID
    */
    public Optional<Reservation> getReservation(int id){
        return repository.findById(id);
    }
    
    /*
    insert & update
    @param admin
    @return actualiza registro ya existente o crea un nuevo registro
    */
    public Reservation save (Reservation reservation){
        return repository.save(reservation);
    }
    
    /*
    Delete from table
    @param admin
    */
    public void delete (Reservation reservation){
        repository.delete(reservation);
    }
}
