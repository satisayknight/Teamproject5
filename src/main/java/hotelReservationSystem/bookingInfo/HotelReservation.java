package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.Price;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HotelReservation {

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Guest guest;
    private Room room;
    private int[] reservationId = new int[200];
    private int currentIndex = 0;
    private double totalCost;

    public HotelReservation() {

    }

    public HotelReservation(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate, int[] reservationId) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationId = reservationId;
        this.totalCost = calculateTotalCost();
    }

    public int[] createANewRoomReservation() {
        int i = reservationId[currentIndex++];

        System.out.println("Your reservationId is: " + i);
        return reservationId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public double getTotalCost() {
        return totalCost;
    }

    private double calculateTotalCost(){
        long totalDaysStayed = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        double totalCost = Price.calculateCosts( room.getRoomTypes(), totalDaysStayed);
        return totalCost;
    }

    @Override
    public String toString() {
        return "Customer: " + this.guest.toString()
                + "\nRoom: " + this.room.toString()
                + "\nCheckIn Date: " + this.checkInDate
                + "\nCheckOut Date: " + this.checkOutDate;
    }
}
