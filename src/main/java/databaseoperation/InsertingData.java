package databaseoperation;

import entities.Address;
import entities.Guest;
import entities.Reservation;
import entities.Room;
import databaseconnection.Connection;

import javax.persistence.Query;


public class InsertingData {


    public void insertRoomIntoDataBase(Room inputRoom) {

        Connection connection = new Connection();

        connection.startTransaction();
        connection.getEm().persist(inputRoom);
        connection.endTransaction();

        connection.closeConnection();

    }

    public void insertGuestIntoDataBase(Guest guest, Address address) {

        Connection connection = new Connection();

        guest.setAddress(address);

        connection.startTransaction();
        connection.getEm().persist(guest);
        connection.getEm().persist(address);
        connection.endTransaction();

        connection.closeConnection();

    }

    public void insertReservation(Reservation reservation, int room_Id, int guest_Id) {

        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("FROM Room WHERE id = :roomNumber");
        query.setParameter("roomNumber", room_Id);
        Room room = (Room) query.getSingleResult();
        Query query1 = connection.getEm().createQuery("FROM Guest WHERE id = :guestNumber");
        query1.setParameter("guestNumber", guest_Id);
        Guest guest = (Guest) query1.getSingleResult();

        reservation.setRoom(room);
        reservation.setGuest(guest);
        guest.addReservation(reservation);

        room.addReservation(reservation);


        connection.startTransaction();
        connection.getEm().persist(reservation);
        connection.endTransaction();

        connection.closeConnection();


    }
}
