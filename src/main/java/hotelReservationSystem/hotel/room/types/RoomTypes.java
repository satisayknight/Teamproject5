package hotelReservationSystem.hotel.room.types;

public class RoomTypes {

    public enum Rooms {
        KING, QUEEN,SUITE;

        public static Rooms getByName(String name) {
            try {
                return valueOf(name.toUpperCase());
            }
            catch(IllegalArgumentException e) {
                System.out.println("Invalid room type. Please choose between: King, Queen, or Suite");
                return null;
            }
        }
    }
}