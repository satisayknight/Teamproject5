package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.room.Price;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.RoomCatalog;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.util.*;

public class InMemoryReservationCatalog implements IReservationCatalog {
    Scanner stdInt = new Scanner(System.in);
    private static int counter = 0;
    private static List<HotelReservation> hotelReservationList = new ArrayList<>();
    private static RoomCatalog availableRooms = new RoomCatalog();
    Guest guestForBooking = new Guest();
    HotelReservation reservation = new HotelReservation();
    Price bookingTotalCost = new Price();
    Room roomReserved = new Room();

    @Override
    public HotelReservation createNewHotelReservation() {
        try {
            //Increment counter by 1 for every hotel reservation made for unique reservationId
            counter = counter + 1;

            //Set Room object for this reservation
            createRoomForReservation();

            //Set Guest object for this reservation
            createGuestForReservation();

            //Days stayed
            System.out.println("How many days would you like to book for?");
            reservation.setDays(stdInt.nextInt());

            //Set reservationId
            reservation.setReservationId(counter);

            //Display details
            System.out.println("Your reservation is successful. The reservation information:");
            System.out.println(reservation.toString());
            //change the reserved room to taken:
            roomReserved.changeRoomToTaken();
            reservation.setRoom(roomReserved);

            //Calculate totalCost for reservation
            double totalCostOfThisReservation = bookingTotalCost.calculateCosts(reservation.getRoom().getRoomTypes(), reservation.getDays());
            reservation.setTotalCost(totalCostOfThisReservation);

            //Add this reservation to the list of reservations
            hotelReservationList.add(reservation);
        }
        catch (IllegalArgumentException e)  {
            throw new IllegalArgumentException("This is error handling message.");
        }
        return reservation;
    }

    public Room createRoomForReservation() {
        //Set roomType and set Room based on user inputs
        System.out.println("Which room would you like to book? 1:King 2:Queen or 3:Suite");
        int roomType = stdInt.nextInt();

        if (roomType == 1) {
            roomReserved = availableRooms.getNextRoomByType(RoomTypes.KING);
            reservation.setRoom(roomReserved);
        } else if (roomType == 2) {
            roomReserved = availableRooms.getNextRoomByType(RoomTypes.QUEEN);
            reservation.setRoom(roomReserved);
        } else if (roomType == 3) {
            roomReserved = availableRooms.getNextRoomByType(RoomTypes.SUITE);
            reservation.setRoom(roomReserved);
        } else {
            System.out.println("Invalid. Please input: 1, 2, or 3.");
        }
        return roomReserved;
    }

    public Guest createGuestForReservation() {
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
        return guestForBooking;
    }

    @Override
    public HotelReservation payForReservation() {
        System.out.println("What is your reservation ID?");
        int reservationId = stdInt.nextInt();
        findById(reservationId);
        stdInt.nextLine();
        if (guestForBooking.isHasBalance() == true) {
            System.out.println("Please input your card information. [Correct Format example 1234-5678 9123 4567]");
            String cardInformation = stdInt.nextLine();
            guestForBooking.setGuestCardNumber(cardInformation);
            guestForBooking.setHasBalance(false);
        } else {
            System.out.println("your balance has been paid");
        }
        return null;
    }


    @Override
    public HotelReservation findById(int id) throws NullPointerException, InputMismatchException {
        HotelReservation result = null;

        try {

            for (HotelReservation reservation : hotelReservationList) {
                if (reservation.getReservationId() == id) {
                    result = reservation;
                    break;
                }
            }
            System.out.println(result.toString());
            System.out.println("Total Cost: " + result.getTotalCost() + " dollars.");

        } catch (NullPointerException | InputMismatchException e) {

            System.out.println("The reservation ID is not valid.\nPlease try again.");


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
        return "InMemoryReservationCatalog: " +
                "\nHotel Reservation List: " + hotelReservationList;
    }
}
