/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.services;

import com.rentcloud.cloud.app.entities.Reservation;
import com.rentcloud.cloud.app.repositories.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RYZEN
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;
    
    /*
    GET
    @return Lista de admin
    */
    public List<Reservation> getAll(){
        return repository.getAll();
    }
    
    /*
    GET/{id}
    @param adminId
    @return
    */
    public Optional<Reservation> getReservation(int reservationId){
        return repository.getReservation(reservationId);
    }
    
    /*
    POST
    @param admin
    @return
    */
    public Reservation save(Reservation reservation){
        //consultar si se envia el ID
        if(reservation.getIdReservation()==null){
            return repository.save(reservation);
        }else{
            //consultar si existe el registro
            Optional<Reservation> existReservation = repository.getReservation(reservation.getIdReservation());
            
            if(existReservation.isPresent()){
                return reservation;
            }else{
                return repository.save(reservation);
            }
        }
    }
    
    /*
    UPDATE
    @param admin
    @return
    */
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> existReservation = repository.getReservation(reservation.getIdReservation());
            
            if(existReservation.isPresent()){
                if(reservation.getStartDate()!=null){
                    existReservation.get().setStartDate(reservation.getStartDate());
                }
                
                if(reservation.getDevolutionDate()!=null){
                    existReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                
                if(reservation.getStatus()!=null){
                    existReservation.get().setStatus(reservation.getStatus());
                }
                
                return repository.save(existReservation.get());
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    /*
    DELETE
    @param adminId
    @return
    */
    public boolean delete(int reservationId){
        Boolean respuesta = getReservation(reservationId).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
