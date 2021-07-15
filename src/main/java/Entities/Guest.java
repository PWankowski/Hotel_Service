package Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservationListGuest;

    public Guest() {
    }

    public Guest(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Reservation> getReservationList() {
        return reservationListGuest;
    }

    public void addReservation(Reservation reservation){
        reservationListGuest.add(reservation);
    }

    @Override
    public String toString() {
        return "Guest:" +
                "ID:" + id +
                ", name:'" + name + '\'' +
                ", surname:'" + surname + '\'' +
                ", address:" + address;
    }
}
