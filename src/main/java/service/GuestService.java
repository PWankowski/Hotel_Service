package service;

import com.mysql.cj.xdevapi.AddResult;
import databaseoperation.InsertingData;
import entities.Address;
import entities.Guest;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GuestService {

    private Scanner scanner = new Scanner(System.in);
    private InsertingData insertingData = new InsertingData();



    public void addGuestIntoDataBase() throws DateTimeParseException {

        System.out.println("Insert Guest name: ");
        String name = scanner.nextLine();
        System.out.println("Insert Guest surname: ");
        String surname = scanner.nextLine();
        System.out.println("Insert Guest birthday in format yyyy-mm-dd:");
        String birthday = scanner.nextLine();

        Guest inputGuest  = new Guest(name,surname,birthday);

        if(checkIfAdult(inputGuest)){
            System.out.println("Insert street name and number:");
            String streetName = scanner.nextLine();
            System.out.println("Insert City");
            String city  = scanner.nextLine();
            System.out.println("Insert postcode");
            String postcode = scanner.nextLine();


            Address inputAddress = new Address(streetName,city,postcode);
            insertingData.insertGuestIntoDataBase(inputGuest,inputAddress);
        }

    }

    public boolean checkIfAdult(Guest guest){

        int age = Period.between(guest.getBirthday(),LocalDate.now()).getYears();

        if(age<18){
            System.out.println("Guest isn't adult, can't add guest to list");
            return false;
        }
        return true;

    }


}
