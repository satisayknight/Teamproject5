package hotelReservationSystem.hotel.room;

import hotelReservationSystem.hotel.room.types.RoomTypes;

import static hotelReservationSystem.hotel.room.types.RoomTypes.*;

public class Price {
    final static int KING_COST = 200;
    final static int QUEEN_COST = 150;
    final static int SUITE_COST = 100;

    public static double calculateCosts(RoomTypes roomTypes, int totalDaysStayed) {
        double stayingCost = 0D;
        if (roomTypes.equals(roomTypes.KING)) {
            stayingCost = KING_COST * totalDaysStayed;
        } else if (roomTypes.equals(roomTypes.QUEEN)) {
            stayingCost = QUEEN_COST * totalDaysStayed;
        } else if (roomTypes.equals(roomTypes.SUITE)) {
            stayingCost = SUITE_COST * totalDaysStayed;
        }
        return stayingCost;
    }
}
