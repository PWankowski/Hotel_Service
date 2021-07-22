package databaseoperation;

import databaseconnection.Connection;

import javax.persistence.Query;


public class UpdatingData {


    public void updateRoomStatus(boolean insertedValue, int searchedID){

        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("UPDATE Room SET isBooked = :TrueOrFalse WHERE id = :idFromUser");
        query.setParameter("idFromUser",searchedID);
        query.setParameter("TrueOrFalse",insertedValue);

        connection.startTransaction();
        query.executeUpdate();
        connection.endTransaction();

        connection.closeConnection();


    }



}
