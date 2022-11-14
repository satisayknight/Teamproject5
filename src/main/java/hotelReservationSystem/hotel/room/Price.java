package hotelReservationSystem.hotel.room;

import hotelReservationSystem.hotel.room.types.RoomTypes;

import static hotelReservationSystem.hotel.room.types.RoomTypes.*;

public class Price {
    final static int KING_COST = 200;
    final static int QUEEN_COST = 150;
    final static int VIP_COST = 100;


    public static double calculateCosts(RoomTypes roomTypes, long totalDaysStayed) {
        double stayingcost = 0;
        if (roomTypes.equals(Rooms.KING)) {
            stayingcost = KING_COST * totalDaysStayed;
        } else if
        (roomTypes.equals(Rooms.QUEEN)) {
            stayingcost = QUEEN_COST * totalDaysStayed;
        } else if (roomTypes.equals(Rooms.SUITE)) {
            stayingcost = VIP_COST * totalDaysStayed;
        }
        return stayingcost;
    }
}
