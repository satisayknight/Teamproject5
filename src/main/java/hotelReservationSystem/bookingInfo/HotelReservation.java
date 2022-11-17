package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.BalanceCalculator;


public class HotelReservation {
    private int days;
    private Guest guest;
    private Room room;
    private int reservationId;
    private double totalCost;

    public HotelReservation() {

    }

    public HotelReservation(int id) {
        this.reservationId = id;
    }

    public HotelReservation(int reservationId, Guest guest, Room room, int daysBooked) {
        this(reservationId);
        this.guest = guest;
        this.room = room;
        this.days = daysBooked;
    }

//    public double calculateTotalCost(int days){
//        double totalCost = BalanceCalculator.calculateCosts( room.getRoomTypes(), days);
//        return totalCost;
//    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Guest " + getGuest() +
                "\nRoom " + getRoom() +
                "\nReservation ID: " + getReservationId() +
                "\nDays: " + getDays() +
                "\nTotal Cost: " + getTotalCost();
    }
}
