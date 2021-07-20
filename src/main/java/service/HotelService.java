package service;

import databaseoperation.DeletingReservation;
import databaseoperation.SelectingFromDataBase;
import entities.Guest;
import entities.Reservation;
import entities.Room;
import databaseoperation.InsertingData;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HotelService {


    private Scanner scanner = new Scanner(System.in);
    private InsertingData insertingData = new InsertingData();
    private SelectingFromDataBase selectingFromDataBase = new SelectingFromDataBase();
    private DeletingReservation deletingReservation = new DeletingReservation();

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


    public void showRooms(){

        selectingFromDataBase.selectingRooms()
                .forEach(System.out::println);

    }

    public void showAvailableRooms(){

        selectingFromDataBase.selectingAvailableRooms()
                .forEach(System.out::println);

    }

    public void showBookedRooms(){
        System.out.println("Insert From Now To ... date in format yyyy-mm-dd:");
        String inputDate = scanner.nextLine();


         selectingFromDataBase.selectingBookedRooms(LocalDate.parse(inputDate))
                 .forEach(System.out::println);

    }

    public void cancelReservation(){
        System.out.println("Insert reservation Id which you want to cancel:");
        long input_Id = scanner.nextLong();

        deletingReservation.deleteReservation(input_Id);

    }

    public void showRoomsToCheckout(){

        List<Reservation> checkoutList = selectingFromDataBase.selectingRoomsToCheckout();
        List<Room> roomsToCheckout = new ArrayList<>();

        for(Reservation r : checkoutList){
           roomsToCheckout.add(r.getRoom());
        }
        System.out.println("Rooms to checkout for today: ");
        roomsToCheckout.forEach(System.out::println);


    }

    public void findGuest(){
        System.out.println("Insert Guest Name: ");
        String inputName = scanner.nextLine();
        System.out.println("Insert Guest Name: ");
        String inputSurname = scanner.nextLine();

        Guest guest = selectingFromDataBase.selectingGuests(inputName,inputSurname);
        if(guest == null){
            System.out.println("Guest don't exist in our dataBase");
        }else{
            System.out.println(guest);
        }



    }





}
