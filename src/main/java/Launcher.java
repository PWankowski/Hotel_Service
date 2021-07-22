import presenter.HotelDisplay;

import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Launcher {

    public static void main(String[] args) {

        HotelDisplay hotelDisplay = new HotelDisplay();

        try{
            hotelDisplay.showRoomsToCheckoutForToday();
            hotelDisplay.showMenu();
        }catch (InputMismatchException  ime){
            System.out.println("Inserted wrong value !");
            ime.printStackTrace();
        }catch (DateTimeParseException dte){
            System.out.println("Inserted wrong date value");
            dte.printStackTrace();
        }


    }
}
