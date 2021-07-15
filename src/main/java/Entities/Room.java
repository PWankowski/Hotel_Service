package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int size;
    private boolean bathroom;
    private boolean isBooked;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservationListRoom;

    public Room() {
    }

    public Room(int size, boolean bathroom, boolean isBooked) {
        this.size = size;
        this.bathroom = bathroom;
        this.isBooked = isBooked;
    }


    public int getSize() {
        return size;
    }

    public boolean isBathroom() {
        return bathroom;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public List<Reservation> getReservationList() {
        return reservationListRoom;
    }

    public void addReservation(Reservation reservation){
        reservationListRoom.add(reservation);
    }

    @Override
    public String toString() {
        return "Room:" +
                "id:" + id +
                ", size:" + size +
                ", bathroom:" + bathroom +
                ", isBooked:" + isBooked;
    }

}
