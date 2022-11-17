package hotelReservationSystem.hotel.room;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.util.Objects;


public class Room {

    private RoomTypes roomType;
    private String roomNumber;
    private boolean isVacant;

    public Room() {

    }

    public Room(String roomNumber, RoomTypes roomType, boolean isVacant) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isVacant=isVacant;

    }


    public String getRoomNumber() {
        return this.roomNumber;
    }

    public RoomTypes getRoomTypes() {
        return this.roomType;
    }

    public boolean getIsVacant() {
        return isVacant;
    }

    public void changeToNotVacant(){
        if(isVacant==true){
            isVacant=false;
        }else{
            System.out.println("The update is not successful because the room is not vacant.");
        }
    }


    public void changeToVacant(){
        if(isVacant==false){
            isVacant=true;
        }else{
            System.out.println("The update is not successful because the room is vacant.");
        }
    }



    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Room) {
            Room other = (Room) obj;
            result = Objects.equals(this.getRoomNumber(),   other.getRoomNumber()) &&
                    Objects.equals(this.getRoomTypes(),  other.getRoomTypes()) &&
                    Objects.equals(this.getIsVacant(), other.getIsVacant());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomNumber(), getRoomTypes(), getIsVacant());
    }

    @Override
    public String toString() {
        return
                "Type: " + roomType +
                "\nRoom Number: " + roomNumber;
    }
}
