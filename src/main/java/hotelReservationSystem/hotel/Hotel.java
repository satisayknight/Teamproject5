package hotelReservationSystem.hotel;

import hotelReservationSystem.hotel.room.Room;

public class Hotel {

    private static final int totalNumberOfRoom=100;
    private int numberOfAvailableRoom;
    private Room room;

    public void booking(){

    }

    public int getNumberOfAvailableRoom() {
        return numberOfAvailableRoom;
    }

    public void setNumberOfAvailableRoom(int numberOfAvailableRoom) {
        this.numberOfAvailableRoom = numberOfAvailableRoom;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
