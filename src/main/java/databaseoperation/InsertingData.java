package databaseoperation;

import Entities.Room;
import databaseconnection.Connection;

public class InsertingData {


    public void insertRoomIntoDataBase(Room inputRoom){

        Connection connection = new Connection();

        connection.startTransaction();
        connection.getEm().persist(inputRoom);
        connection.endTransaction();

        connection.closeConnection();

    }




}
