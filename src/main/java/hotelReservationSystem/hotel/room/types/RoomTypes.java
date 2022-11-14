package hotelReservationSystem.hotel.room.types;

public enum RoomTypes {

    KING("1"), QUEEN("2"), SUITE("3");

    public final String label;

    private RoomTypes(String label) {
        this.label = label;
    }

    public static RoomTypes valueOfLabel(String label) {
        for (RoomTypes roomType : values()) {
            if (roomType.label.equals(label)) {
                return roomType;
            }
        }
        throw new IllegalArgumentException();
    }

}
