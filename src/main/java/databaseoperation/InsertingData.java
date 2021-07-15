package databaseoperation;

import entities.Address;
import entities.Guest;
import entities.Room;
import databaseconnection.Connection;

public class InsertingData {


    public void insertRoomIntoDataBase(Room inputRoom){

        Connection connection = new Connection();

        connection.startTransaction();
        connection.getEm().persist(inputRoom);
        connection.endTransaction();

        connection.closeConnection();

    }

    public void insertGuestIntoDataBase(Guest guest, Address address){

        Connection connection = new Connection();

        guest.setAddress(address);

        connection.startTransaction();
        connection.getEm().persist(guest);
        connection.getEm().persist(address);
        connection.endTransaction();

        connection.closeConnection();

    }




}
