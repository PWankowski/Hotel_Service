package databaseoperation;

import databaseconnection.Connection;
import entities.Guest;
import entities.Reservation;
import entities.Room;
import exceptions.GuestNotFoundException;


import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class SelectingFromDataBase {

    public List<Room> selectingRooms() {

        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("FROM Room");
        List<Room> roomslist = query.getResultList();

        connection.closeConnection();
        return roomslist;

    }

    public List<Room> selectingAvailableRooms() {

        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("FROM Room WHERE isBooked = false");
        List<Room> availableRoomsList = query.getResultList();


        connection.closeConnection();

        return availableRoomsList;


    }

    public List<Reservation> selectingBookedRooms(LocalDate inputDate) {
        LocalDate localDate = LocalDate.now();

        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("FROM Reservation  WHERE checkout >= :TodayDate AND checkout < :FutureDate ");
        query.setParameter("TodayDate", localDate);
        query.setParameter("FutureDate", inputDate);
        List<Reservation> reservationList = query.getResultList();

        connection.closeConnection();
        return reservationList;


    }

    public List<Reservation> selectingBookedRooms(LocalDate firstDate, LocalDate secondDate) {

        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("FROM Reservation  WHERE checkout >= :firstDate AND checkout < :nextDate ");
        query.setParameter("firstDate", firstDate);
        query.setParameter("nextDate", secondDate);
        List<Reservation> reservationList = query.getResultList();

        connection.closeConnection();
        return reservationList;


    }

    public List<Reservation> selectingRoomsToCheckout() {
        LocalDate localDate = LocalDate.now();

        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("FROM Reservation  WHERE checkout = :TodayDate");
        query.setParameter("TodayDate", localDate);
        List<Reservation> reservationList = query.getResultList();

        connection.closeConnection();
        return reservationList;


    }

    public List<Guest> selectingGuests(String inputName, String inputSurname) throws GuestNotFoundException {
        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("FROM Guest  WHERE name = :Name AND surname = : Surname");
        query.setParameter("Name", inputName);
        query.setParameter("Surname", inputSurname);

        try {
            return query.getResultList();
        } catch (NoResultException nr) {
            throw new GuestNotFoundException();
        } finally {
            connection.closeConnection();
        }

    }


}
