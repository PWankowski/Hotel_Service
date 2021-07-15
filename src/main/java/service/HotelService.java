package service;

import Entities.Room;
import databaseoperation.InsertingData;

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





}
