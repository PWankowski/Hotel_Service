import presenter.HotelDisplay;

import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Launcher {

    private static HotelDisplay hotelDisplay = new HotelDisplay();

    public static void main(String[] args) {



        hotelDisplay.showRoomsToCheckoutForToday();
        hotelDisplay.showMenu();


    }
}
