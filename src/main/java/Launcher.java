import presenter.HotelDisplay;

import java.util.InputMismatchException;

public class Launcher {

    public static void main(String[] args) {

        HotelDisplay hotelDisplay = new HotelDisplay();

        try{
            hotelDisplay.showMenu();
        }catch (InputMismatchException ime){
            System.out.println("Inserted wrong value !");
            ime.printStackTrace();
        }


    }
}
