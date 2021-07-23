package databaseoperation;

import databaseconnection.Connection;
import entities.Guest;
import entities.Reservation;
import entities.Room;

import javax.persistence.Query;
import java.util.List;


public class DeletingReservation {


    public void deleteReservation(long idFromUser){
        Connection connection = new Connection();
        Query query = connection.getEm().createQuery("FROM Reservation WHERE id = :input_Id");
        query.setParameter("input_Id",idFromUser);

        Reservation reservation = (Reservation) query.getSingleResult();
        Guest guest = reservation.getGuest();
        guest.getReservationList().removeIf(r -> r.getId() == idFromUser);


        Room room = reservation.getRoom();
        room.getReservationList().removeIf(r -> r.getId() == idFromUser);



        Query query1 = connection.getEm().createQuery("DELETE FROM Reservation WHERE id = :input_Id");
        query1.setParameter("input_Id",idFromUser);
        connection.startTransaction();
        query1.executeUpdate();
        connection.endTransaction();

        connection.closeConnection();


    }


}
