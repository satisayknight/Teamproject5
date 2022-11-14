package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.Price;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class HotelReservation {
    Scanner stdInt = new Scanner(System.in);
    private int days;
    private Guest guest;
    private Room room;
    private int[] reservationId = new int[200];
    private int currentIndex = 0;
    private double totalCost;

    public HotelReservation() {

    }

    public HotelReservation(Guest guest, Room room, int daysBooked, int[] reservationId) {
        this.guest = guest;
        this.room = room;
        this.days = daysBooked;
        this.reservationId = reservationId;
        this.totalCost = calculateTotalCost(daysBooked);
    }

    public int[] createANewRoomReservation(RoomTypes roomTypes) {
        int i = reservationId[currentIndex++];
        System.out.println("When is your check-in and check-out? ");
        return reservationId;
    }


    public Room getRoom() {
        return room;
    }

    public double getTotalCost() {
        return totalCost;
    }

    private double calculateTotalCost(int days){
        double totalCost = Price.calculateCosts( room.getRoomTypes(), days);
        return totalCost;
    }

    @Override
    public String toString() {
        return "Customer: " + this.guest.toString()
                + "\nRoom: " + this.room.toString();

    }
}
