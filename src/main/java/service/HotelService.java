package service;

import databaseoperation.DeletingReservation;
import databaseoperation.SelectingFromDataBase;
import databaseoperation.UpdatingData;
import entities.Guest;
import entities.Reservation;
import entities.Room;
import databaseoperation.InsertingData;
import exceptions.GuestNotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class HotelService {


    private Scanner scanner = new Scanner(System.in);
    private InsertingData insertingData = new InsertingData();
    private SelectingFromDataBase selectingFromDataBase = new SelectingFromDataBase();
    private DeletingReservation deletingReservation = new DeletingReservation();
    private UpdatingData updatingData = new UpdatingData();

    public void addRoomToHotel() throws InputMismatchException {

        System.out.println("For how many persons room will be available(size):");
        int size = scanner.nextInt();
        System.out.println("Is bathroom in this room? true or false if not :");
        boolean isBathroom = scanner.nextBoolean();
        System.out.println("Is this room booked? true or false if not:");
        boolean isBooked = scanner.nextBoolean();

        Room room = new Room(size, isBathroom, isBooked);
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
        Reservation reservation = new Reservation(priceForReservation, startDate, endDate);

        insertingData.insertReservation(reservation, room_Id, guest_Id);

    }


    public void showRooms() {

        selectingFromDataBase.selectingRooms()
                .forEach(System.out::println);

    }

    public void showAvailableRooms() {

        List<Room> availableRoomsList = selectingFromDataBase.selectingAvailableRooms();
        if (availableRoomsList.isEmpty()) {
            System.out.println("All rooms are booked!");
        } else {
            availableRoomsList.forEach(System.out::println);
        }


    }

    public void showBookedRoomsWithReservation() throws InputMismatchException {
        System.out.println("If you want search by TodayDate until nextDate press 1 if you want to input your own period of time press 2");
        int userInput = scanner.nextInt();
        scanner.nextLine();

        if (userInput == 1) {
            System.out.println("Insert From Now To ... date in format yyyy-mm-dd:");
            String inputDate = scanner.nextLine();
            selectingFromDataBase.selectingBookedRooms(LocalDate.parse(inputDate))
                    .forEach(System.out::println);

        } else if (userInput == 2) {
            System.out.println("Insert start  date in format yyyy-mm-dd:");
            String startDate = scanner.nextLine();
            System.out.println("Insert end  date in format yyyy-mm-dd:");
            String endDate = scanner.nextLine();
            selectingFromDataBase.selectingBookedRooms(LocalDate.parse(startDate), LocalDate.parse(endDate))
                    .forEach(System.out::println);
        } else {
            System.out.println("Inserted value isn't correct!");
        }


    }

    public void cancelReservation() throws InputMismatchException {
        System.out.println("Insert reservation Id which you want to cancel:");
        long input_Id = scanner.nextLong();

        deletingReservation.deleteReservation(input_Id);

    }

    public void showRoomsToCheckout() {

        List<Reservation> checkoutList = selectingFromDataBase.selectingRoomsToCheckout();
        List<Room> roomsToCheckout = new ArrayList<>();

        for (Reservation r : checkoutList) {
            roomsToCheckout.add(r.getRoom());
        }
        System.out.println("Rooms to checkout for today: ");
        roomsToCheckout.forEach(System.out::println);


    }

    public void findGuest() throws GuestNotFoundException {
        System.out.println("Insert Guest Name: ");
        String inputName = scanner.nextLine();
        System.out.println("Insert Guest Name: ");
        String inputSurname = scanner.nextLine();

        List<Guest> guestsLists = selectingFromDataBase.selectingGuests(inputName, inputSurname);
        if (guestsLists.isEmpty()) {
            System.out.println("Guest don't exist in our dataBase");
        } else {
            guestsLists.forEach(System.out::println);
        }

    }

    public void takeTheRoom() throws InputMismatchException {
        System.out.println("Insert room id which you want to occupied");
        int room_id = scanner.nextInt();

        Optional<Room> room = selectingFromDataBase.selectingRooms().stream()
                .filter(r -> r.getId() == room_id)
                .findFirst();
        if (room.isEmpty()) {
            System.out.println("Room doesn't exist");
        } else {
            updatingData.updateRoomStatus(true, room_id);
            System.out.println("Room was successfully occupied");
        }

    }

    public void freeTheRoom() throws InputMismatchException {
        System.out.println("Insert room id which you want to occupied");
        int room_id = scanner.nextInt();

        Optional<Room> room = selectingFromDataBase.selectingRooms().stream()
                .filter(r -> r.getId() == room_id)
                .findFirst();
        if (room.isEmpty()) {
            System.out.println("Room doesn't exist");
        } else {
            updatingData.updateRoomStatus(false, room_id);
            System.out.println("Room was successfully free");
        }

    }
}
