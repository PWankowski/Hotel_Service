package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private LocalDate birthday;


    @OneToOne
    @JoinColumn(name = "Address_ID", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservationListGuest;

    public Guest() {
    }

    public Guest(String name, String surname, String birthday) throws DateTimeParseException {
        this.name = name;
        this.surname = surname;
        this.birthday = LocalDate.parse(birthday);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthday() {
        return birthday;
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
