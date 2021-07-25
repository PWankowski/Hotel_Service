package databaseoperation;

import databaseconnection.Connection;

import javax.persistence.Query;
import java.time.LocalDate;


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


    public void updateAddress(String city, String postCode, String street, int guestId){

        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("UPDATE Address SET city = :inputCity  WHERE id = (SELECT address FROM Guest WHERE id = :inputId)");
        Query query1 = connection.getEm().createQuery("UPDATE Address SET postCode = :inputPostCode  WHERE id = (SELECT address FROM Guest WHERE id = :inputId)");
        Query query2= connection.getEm().createQuery("UPDATE Address SET street = :inputStreet  WHERE id = (SELECT address FROM Guest WHERE id = :inputId)");
        query.setParameter("inputCity",city);
        query1.setParameter("inputPostCode",postCode);
        query2.setParameter("inputStreet",street);
        query.setParameter("inputId",guestId);
        query1.setParameter("inputId",guestId);
        query2.setParameter("inputId",guestId);



        connection.startTransaction();
        query.executeUpdate();
        query1.executeUpdate();
        query2.executeUpdate();
        connection.endTransaction();

        connection.closeConnection();


    }






}
