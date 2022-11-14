package hotelReservationSystem.hotel;

import hotelReservationSystem.hotel.room.Room;

public class Hotel {

    private static final int totalNumberOfAvailableKingRoom=20;
    private static final int totalNumberOfAvailableQueenRoom=20;
    private static final int totalNumberOfAvailableSuite=20;

    private Room room;

    public void booking(){

    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
