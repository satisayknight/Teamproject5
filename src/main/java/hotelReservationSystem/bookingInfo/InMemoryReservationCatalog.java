package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.room.Price;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.RoomCatalog;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.util.*;

public class InMemoryReservationCatalog implements IReservationCatalog {
    private static int counter = 0;
    private static List<HotelReservation> hotelReservationList = new ArrayList<>();

    public static HotelReservation createNewHotelReservation() {
        counter = counter + 1;
        Scanner stdInt = new Scanner(System.in);
        HotelReservation reservation = new HotelReservation();
        RoomCatalog availableRooms = new RoomCatalog();
        Guest guestForBooking = new Guest();
        Price bookingTotalCost = new Price();

        //Set roomType and set Room
        System.out.println("Which room would you like to book? 1:King 2:Queen or 3:Suite");
        int roomType = stdInt.nextInt();
        Room roomReserved = null;
        if (roomType == 1) {
            roomReserved=availableRooms.getNextRoomByType(RoomTypes.KING);
            reservation.setRoom(roomReserved);
            System.out.println(roomReserved);
        } else if (roomType == 2) {
            roomReserved=availableRooms.getNextRoomByType(RoomTypes.QUEEN);
            reservation.setRoom(roomReserved);
            System.out.println(roomReserved);
        } else if (roomType == 3) {
            roomReserved=availableRooms.getNextRoomByType(RoomTypes.SUITE);
            reservation.setRoom(roomReserved);
            System.out.println(roomReserved);
        } else {
            System.out.println("Invalid. Please input: 1, 2, or 3.");
        }

        //Get Guest info
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

        //Days stayed
        System.out.println("How many days would you like to book for?");
        reservation.setDays(stdInt.nextInt());

        //Set reservationId
        reservation.setReservationId(counter);
        System.out.println(reservation.getReservationId());

        //Display details
        System.out.println("Your reservation is successful. The reservation information:");
        System.out.println(reservation.toString());
        //change the reserved room to taken:
        roomReserved.changeRoomToTaken();
        reservation.setRoom(roomReserved);
        //System.out.println(roomReserved);
        hotelReservationList.add(reservation);

        bookingTotalCost.calculateCosts(reservation.getRoom().getRoomTypes(), reservation.getDays());
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
        System.out.println(result.toString());
        System.out.println(result.getTotalCost());
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
