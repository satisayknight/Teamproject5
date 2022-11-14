package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.hotel.Hotel;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.util.*;

public class InMemoryReservationCatalog implements IReservationCatalog {
    private List<HotelReservation> hotelReservationList;

    public static HotelReservation createNewHotelReservation() {
//        Scanner stdInt = new Scanner(System.in);
        HotelReservation reservation = new HotelReservation();
//        Room aRoom = new Room();
//        System.out.println("Which room would you like to book? 1:King 2:Queen or 3:Suite");
//        int roomType = stdInt.nextInt();
//
//        if (roomType > 0 && roomType < 4) {
//            aRoom.
//        } else {
//            System.out.println("Invalid. Please input: 1, 2, or 3.");
//        }
        return reservation;
    }

    @Override
    public HotelReservation findById(int id) {
        HotelReservation result = null;

        for (HotelReservation reservation : hotelReservationList) {
            if (reservation.getReservationId() == id) {
                result = reservation;
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return hotelReservationList.size();
    }

    @Override
    public Collection<HotelReservation> getAll() {
        return Collections.unmodifiableCollection(hotelReservationList);
    }
}
