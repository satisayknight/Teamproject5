package hotelReservationSystem.hotel.room;

import hotelReservationSystem.hotel.room.types.RoomTypes;


public class Room {
    private final Double price;
    private final RoomTypes roompicked;


    public Room(Double price, RoomTypes rooming) {
        this.price = price;
        this.roompicked = rooming;
    }

    public Double getPrice() {
        return price;
    }

    public RoomTypes getRoompicked() {
        return roompicked;
    }

    @Override
    public String toString() {
        return
                " Price: $" + this.price
                        + "Staying in" + this.roompicked;
    }
}
