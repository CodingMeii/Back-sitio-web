/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories.crud;

import com.rentcloud.cloud.app.entities.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author RYZEN
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
    //Cantidad de reservas dependiendo la nube
    @Query("SELECT c.cloud, COUNT(c.cloud) from Reservation AS c group by c.cloud order by COUNT(c.cloud) DESC")
    public List<Object[]> countTotalReservationsByCloud();

    //select clientId, count(*) as "total" from reservation group by clientId order by total desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);

    public List<Reservation>findAllByStatus(String status);
}
