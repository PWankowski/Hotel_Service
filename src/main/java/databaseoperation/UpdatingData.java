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
//AND postCode = :inputPostCode AND street = :inputStreet WHERE id IN (SELECT Address_ID FROM Guest WHERE id = :inputId"

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

  /*  public void updateGuestName(int guestId, String name){
        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("UPDATE Guest SET name = :Name WHERE id = :idFromUser");
        query.setParameter("Name",name);
        query.setParameter("idFromUser",guestId);




        connection.startTransaction();
        query.executeUpdate();
        connection.endTransaction();

        connection.closeConnection();

    }

    public void updateGuestSurname(int guestId, String surname){
        Connection connection = new Connection();

        Query query = connection.getEm().createQuery("UPDATE Guest SET surname = :Surname WHERE id = :idFromUser");
        query.setParameter("Surname",surname);
        query.setParameter("idFromUser",guestId);




        connection.startTransaction();
        query.executeUpdate();
        connection.endTransaction();

        connection.closeConnection();

    }*/

  /*  public void updateGuestBirthday(int guestId, String birthday){
        Connection connection = new Connection();
        LocalDate updatedBirthday = LocalDate.parse(birthday);

        Query query = connection.getEm().createQuery("UPDATE Guest SET birthday = :Birthday WHERE id = :idFromUser");
        query.setParameter("Birthday",updatedBirthday);
        query.setParameter("idFromUser",guestId);

        connection.startTransaction();
        query.executeUpdate();
        connection.endTransaction();

        connection.closeConnection();

    }*/





}
