package databaseoperation;

import databaseconnection.Connection;
import entities.Room;


import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SelectingFromDataBase {

    public List<Room> selectingRooms(){

        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("FROM Room");
        List<Room> roomslist = query.getResultList();

        connection.closeConnection();
        return roomslist;

    }

    public List<Room> selectingAvailableRooms(){

        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("FROM Room WHERE isBooked = 0");
        List<Room> availableRoomsList = query.getResultList();


        connection.closeConnection();

        return availableRoomsList;





    }



}
