package hotelReservationSystem.hotel.room;

import hotelReservationSystem.hotel.room.types.RoomTypes;


public class Room {
    private final Double price;
    private final RoomTypes roompicked;
    private String roomNumber;


    public Room(String roomNumber,Double price, RoomTypes rooming) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roompicked = rooming;

    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public Double getPrice() {
        return this.price;
    }

    public RoomTypes getRoompTypes() {
        return this.roompicked;
    }

    @Override
    public String toString() {
        return "Room Number: " + this.roomNumber +
                " Price: $" + this.price
                + "Staying in" + this.roompicked;
    }
}
