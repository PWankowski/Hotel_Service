package Entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double price;
    private LocalDate checkin;
    private LocalDate checkout;

    @ManyToOne
    @JoinColumn(name = "Room_ID")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "Guest_ID")
    private Guest guest;

    public Reservation() {
    }

    public Reservation(double price, String checkin, String checkout) {
        this.price = price;
        this.checkin = LocalDate.parse(checkin);
        this.checkout = LocalDate.parse(checkout);
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
