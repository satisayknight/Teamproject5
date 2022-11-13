package hotelReservationSystem.hotel.room;

import hotelReservationSystem.hotel.room.types.RoomTypes;


public class Room {

    private final RoomTypes roompicked;
    private String roomNumber;


    public Room(String roomNumber, RoomTypes rooming) {
        this.roomNumber = roomNumber;
        this.roompicked = rooming;

    }


    public String getRoomNumber() {
        return this.roomNumber;
    }


    public RoomTypes getRoomTypes() {
        return this.roompicked;
    }

    @Override
    public String toString() {
        return "Room Number: " + this.roomNumber
                + "Staying in" + this.roompicked;
    }
}
