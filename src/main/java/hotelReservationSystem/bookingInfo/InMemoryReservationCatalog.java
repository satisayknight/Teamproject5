package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.Hotel;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.RoomCatalog;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.util.*;

public class InMemoryReservationCatalog implements IReservationCatalog {
    private List<HotelReservation> hotelReservationList;

    public static HotelReservation createNewHotelReservation() {
        Scanner stdInt = new Scanner(System.in);
        HotelReservation reservation = new HotelReservation();
        RoomCatalog roomForBooking = new RoomCatalog();
        Guest guestForBooking = new Guest();

        System.out.println("Which room would you like to book? 1:King 2:Queen or 3:Suite");
        int roomType = stdInt.nextInt();
        if (roomType == 1) {
            roomForBooking.getNextRoomByType(RoomTypes.KING);
            System.out.println(roomForBooking.getNextRoomByType(RoomTypes.KING));
        } else if (roomType == 2) {
            roomForBooking.getNextRoomByType(RoomTypes.QUEEN);
            System.out.println(roomForBooking.getNextRoomByType(RoomTypes.QUEEN));
        } else if (roomType == 3) {
            roomForBooking.getNextRoomByType(RoomTypes.SUITE);
            System.out.println(roomForBooking.getNextRoomByType(RoomTypes.SUITE));
        } else {
            System.out.println("Invalid. Please input: 1, 2, or 3.");
        }

        stdInt.nextLine();
        System.out.println("What is your name?");
        guestForBooking.setGuestName(stdInt.nextLine());
        System.out.println("What is your email?");
        guestForBooking.setGuestEmail(stdInt.nextLine());
        System.out.println("What is your phone number?");
        guestForBooking.setGuestPhoneNumber(stdInt.nextLine());

        System.out.println(guestForBooking.toString());
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

    @Override
    public String toString() {
        return "InMemoryReservationCatalog{" +
                "hotelReservationList=" + hotelReservationList +
                '}';
    }
}
