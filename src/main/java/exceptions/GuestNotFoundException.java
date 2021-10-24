package exceptions;



public class GuestNotFoundException extends RuntimeException {



    public GuestNotFoundException() {
        super("Guest don't exist in our dataBase");
    }


}
