package hotelReservationSystem.hotel;

import hotelReservationSystem.hotel.room.Room;

public class Hotel {

    private static final int totalNumberOfRoom=200;
    private int numberOfAvailableRoom;
    private int numberOfOccupiedRoom=200-numberOfAvailableRoom;
    private Room room;


    public void booking(){

    }

    public int getNumberOfAvailableRoom() {
        return numberOfAvailableRoom;
    }

    public void setNumberOfAvailableRoom(int numberOfAvailableRoom) {
        this.numberOfAvailableRoom = numberOfAvailableRoom;
    }

    public int getNumberOfOccupiedRoom() {
        return numberOfOccupiedRoom;
    }

    public void setNumberOfOccupiedRoom(int numberOfOccupiedRoom) {
        this.numberOfOccupiedRoom = numberOfOccupiedRoom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}