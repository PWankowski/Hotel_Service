package presenter;

import service.HotelService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelDisplay {

    private Scanner scanner = new Scanner(System.in);
    private boolean nextMove = true;
    private HotelService  hotelService = new HotelService();



    public void showMenu() throws InputMismatchException {

        do{

            System.out.println("0 - to close the program");
            System.out.println("1 - Add new room into hotel base");



            int inputNumber = scanner.nextInt();
            switch(inputNumber) {
                case 0:
                    nextMove = false;
                    break;
                case 1:
                    hotelService.addRoomToHotel();
                    break;


            }


        }while(nextMove);


    }






}
