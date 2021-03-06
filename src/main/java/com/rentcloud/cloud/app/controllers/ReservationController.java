/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.controllers;

import com.rentcloud.cloud.app.entities.Reservation;
import com.rentcloud.cloud.app.entities.custom.CountClient;
import com.rentcloud.cloud.app.entities.custom.CountCloud;
import com.rentcloud.cloud.app.entities.custom.StatusAmount;
import com.rentcloud.cloud.app.services.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RYZEN
 */
@RestController
@RequestMapping("Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
    @Autowired
    private ReservationService service;
    
    /*
    GET
    @return
    */
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getAll();
    }
    
    /*
    GET/{id}
    @param adminId
    @return
    */
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId){
        return service.getReservation(reservationId);
    }
    
    /*
    POST
    @param admin
    @return
    */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation){
        return service.save(reservation);
    }
    
    /*
    PUT
    @param admin
    @return
    */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update (@RequestBody Reservation reservation){
        return service.update(reservation);
    }
    
    /*
    DELETE
    @param admin
    @return
    */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId){
        return service.delete(reservationId);
    }
    @GetMapping("/report-clouds")
    public List<CountCloud> getReservationsReportCloud(){
        return service.getTopCloud();
    }
    
    //lo mismo que con client
    @GetMapping("/report-clients")
    public List<CountClient> gerReservationsReportClient() {
        return service.getTopClient();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return service.getReservationsPeriod(dateOne, dateTwo);
    }
    
    @GetMapping("/report-dates/amount/{dateOne}/{dateTwo}")
    public Integer getReservationsReportDatesAmount(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return service.getReservationsPeriod(dateOne, dateTwo).size();
    }
    
    @GetMapping("/report-status")
    public StatusAmount getReservationsStatusReport(){
        return service.getReservationsStatusReport();
    }
}
