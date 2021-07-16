package service;

import entities.Reservation;
import entities.Room;
import databaseoperation.InsertingData;

import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelService {


    private Scanner scanner = new Scanner(System.in);
    private InsertingData insertingData = new InsertingData();

    public void addRoomToHotel() throws InputMismatchException {

        System.out.println("For how many persons room will be available(size):");
        int size = scanner.nextInt();
        System.out.println("Is bathroom in this room? true or false if not :");
        boolean isBathroom = scanner.nextBoolean();
        System.out.println("Is this room booked? true or false if not:");
        boolean isBooked = scanner.nextBoolean();

        Room room = new Room(size,isBathroom,isBooked);
        insertingData.insertRoomIntoDataBase(room);

    }

    public void makeReservation() throws InputMismatchException, DateTimeParseException {

        System.out.println("Insert room number which you want to reserve");
        int room_Id = scanner.nextInt();
        System.out.println("Insert guest id to do a reservation");
        int guest_Id = scanner.nextInt();
        System.out.println("Price: ");
        double priceForReservation = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Insert start date in format yyyy-mm-dd:");
        String startDate = scanner.nextLine();
        System.out.println("Insert end date in format yyyy-mm-dd:");
        String endDate = scanner.nextLine();
        Reservation reservation = new Reservation(priceForReservation,startDate,endDate);

        insertingData.insertReservation(reservation,room_Id,guest_Id);

    }





}
