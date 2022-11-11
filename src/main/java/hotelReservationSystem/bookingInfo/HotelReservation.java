package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.room.Room;

import java.util.Date;
import java.util.Scanner;

public class HotelReservation {

    private Date checkInDate;
    private Date checkOutDate;
    private Guest guest;
    private Room room;
    private int reservationId;

    public HotelReservation() {

    }

    public HotelReservation(Guest guest, Room room, Date checkInDate, Date checkOutDate, int reservationId) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationId = reservationId;
    }

    public int createANewRoomReservation() {
        Scanner stdInt = new Scanner(System.in);

        System.out.println();
        return reservationId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Customer: " + this.guest.toString()
                + "\nRoom: " + this.room.toString()
                + "\nCheckIn Date: " + this.checkInDate
                + "\nCheckOut Date: " + this.checkOutDate;
    }
}
