/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Client;
import com.rentcloud.cloud.app.entities.Cloud;
import com.rentcloud.cloud.app.entities.Reservation;
import com.rentcloud.cloud.app.entities.custom.CountClient;
import com.rentcloud.cloud.app.entities.custom.CountCloud;
import com.rentcloud.cloud.app.repositories.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
    
    public List<CountCloud> getTopCloud(){
        List<CountCloud> respuesta = new ArrayList<>();
        List<Object[]> reporte = repository.countTotalReservationsByCloud();
        
        for(int i=0; i<reporte.size(); i++){
            respuesta.add(new CountCloud((Long) reporte.get(i)[1],(Cloud) reporte.get(i)[0]));
        }
        
        return respuesta;
    }
    
    public List<CountClient> getTopClient(){
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = repository.countTotalReservationsByClient();
        
        for(int i=0; i<reporte.size(); i++){
            respuesta.add(new CountClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        
        return respuesta;
    }
    
    public List<Reservation> getReservationPeriod(Date fechaInicial, Date fechaFinal){
        return repository.findAllByStartDateAfterAndStartDateBefore(fechaInicial, fechaFinal);
    }
    
    public List<Reservation> getReservationsByStatus(String status){
        return repository.findAllByStatus(status);
    }
}
