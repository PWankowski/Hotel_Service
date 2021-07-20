package exceptions;

import java.sql.SQLException;

public class GuestNotFoundException extends Exception {

    private String getMessage;

    public GuestNotFoundException(String getMessage) {
        this.getMessage = getMessage;
    }

    public String getGetMessage() {
        return getMessage;
    }
}
