package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.room.RoomCatalog;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.util.*;

public class InMemoryReservationCatalog implements IReservationCatalog {
    private static int counter = 0;
    private List<HotelReservation> hotelReservationList;

    public static HotelReservation createNewHotelReservation() {
        Scanner stdInt = new Scanner(System.in);
        HotelReservation reservation = new HotelReservation();
        RoomCatalog roomForBooking = new RoomCatalog();
        Guest guestForBooking = new Guest();

        System.out.println("Which room would you like to book? 1:King 2:Queen or 3:Suite");
        int roomType = stdInt.nextInt();
        if (roomType == 1) {
            reservation.setRoom(roomForBooking.getNextRoomByType(RoomTypes.KING));
            System.out.println(roomForBooking.getNextRoomByType(RoomTypes.KING));
        } else if (roomType == 2) {
            reservation.setRoom(roomForBooking.getNextRoomByType(RoomTypes.QUEEN));
            System.out.println(roomForBooking.getNextRoomByType(RoomTypes.QUEEN));
        } else if (roomType == 3) {
            reservation.setRoom(roomForBooking.getNextRoomByType(RoomTypes.SUITE));
            System.out.println(roomForBooking.getNextRoomByType(RoomTypes.SUITE));
        } else {
            System.out.println("Invalid. Please input: 1, 2, or 3.");
        }

        stdInt.nextLine();
        System.out.println("What is your name?");
        Guest guestNameToBook = guestForBooking;
        guestNameToBook.setGuestName(stdInt.nextLine());
        System.out.println("What is your email?");
        Guest guestEmailToBook = guestForBooking;
        guestEmailToBook.setGuestEmail(stdInt.nextLine());
        System.out.println("What is your phone number?");
        Guest guestPhoneNumberToBook = guestForBooking;
        guestPhoneNumberToBook.setGuestPhoneNumber(stdInt.nextLine());
        reservation.setGuest(guestForBooking);


        System.out.println("How many days would you like to book for?");
        reservation.setDays(stdInt.nextInt());

        reservation.setReservationId(counter++);
        System.out.println(reservation.getReservationId());

        System.out.println(reservation.toString());
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
