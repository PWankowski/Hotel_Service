package presenter;

import service.GuestService;
import service.HotelService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelDisplay {

    private Scanner scanner = new Scanner(System.in);
    private boolean nextMove = true;
    private HotelService  hotelService = new HotelService();
    private GuestService guestService = new GuestService();



    public void showMenu() throws InputMismatchException {

        do{

            System.out.println("0 - To close the program");
            System.out.println("1 - Add new room into hotel base");
            System.out.println("2 - Add new guest");
            System.out.println("3 - Make a Reservation");
            System.out.println("4 - To view all Rooms");
            System.out.println("5 - To view available Rooms");
            System.out.println("6 - To view booked Rooms with reservation date and  accommodated  guests");



            int inputNumber = scanner.nextInt();
            switch(inputNumber) {
                case 0:
                    nextMove = false;
                    break;
                case 1:
                    hotelService.addRoomToHotel();
                    break;
                case 2:
                    guestService.addGuestIntoDataBase();
                    break;
                case 3:
                    hotelService.makeReservation();
                    break;
                case 4:
                    hotelService.showRooms();
                    break;
                case 5:
                    hotelService.showAvailableRooms();
                    break;
                case 6:
                    hotelService.showBookedRooms();



            }


        }while(nextMove);


    }






}
