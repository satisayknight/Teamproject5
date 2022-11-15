package hotelReservationSystem.hotel.room;

import hotelReservationSystem.hotel.room.types.RoomTypes;


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

    public void changeRoomToTaken(){
        if(isVacant==true){
            isVacant=false;
        }else{
            System.out.println("The room is already taken.");
        }

    }
    public void changeRoomToVacant(){
        if(isVacant==false){
            isVacant=true;
        }else{
            System.out.println("The room is already vacant.");
        }

    }


    @Override
    public String toString() {
        return "Room{" +
                "roomType=" + roomType +
                ", roomNumber='" + roomNumber + '\'' +
                ", isVacant=" + isVacant +
                '}';
    }
}
