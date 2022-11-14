package hotelReservationSystem.hotel.room;

import hotelReservationSystem.hotel.room.types.RoomTypes;


public class Room {

    private final RoomTypes roomType;
    private String roomNumber;


    public Room(String roomNumber, RoomTypes roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }


    public String getRoomNumber() {
        return this.roomNumber;
    }


    public RoomTypes getRoomTypes() {
        return this.roomType;
    }

    @Override
    public String toString() {
        return "Room Number: " + this.roomNumber
                + "Staying in" + this.roomType;
    }
}
