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
    public HotelReservation createNewHotelReservation() throws IllegalArgumentException, InputMismatchException {
        try {
            //Increment counter by 1 for every hotel reservation made for unique reservationId
            counter = counter + 1;

            //Set Room object for this reservation
            createRoomForReservation();

            //Set Guest object for this reservation
            createGuestForReservation();

            //Days stayed
            daysToBook();

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
        } catch (InputMismatchException e) {
            System.out.print("Wrong Input\n");
        }
        return reservation;
    }

    public void daysToBook() {
        boolean isValidDays = false;
        while (!isValidDays) {
            System.out.println("How many days would you like to book for?");
            int daysToBook = stdInt.nextInt();
            if (daysToBook < 0 || daysToBook > 15) {
                System.out.println("Please input a valid number of days to book.");
            } else {
                isValidDays = true;
                reservation.setDays(daysToBook);
            }
        }
    }

    public Room createRoomForReservation() throws IllegalArgumentException, InputMismatchException {

        try {
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
                createRoomForReservation();
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("This is an input mismatch handling message.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("This is an illegal argument handling message.");
        }
        return roomReserved;
    }

    public Guest createGuestForReservation() throws IllegalArgumentException, InputMismatchException {
        try {
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
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.print("Wrong Input\n");
            System.out.println("Press 'Enter' To Restart");
            createGuestForReservation();
        }
        return guestForBooking;
    }

    @Override
    public Guest payForReservation() {
        System.out.println("What is your reservation ID?");
        int reservationId = stdInt.nextInt();
        stdInt.nextLine();
        Guest guest = null;
        //HotelReservation result = findById(reservationId);
        try {
            for (HotelReservation reservation : hotelReservationList) {
                if (reservation.getReservationId() == reservationId) {
                    guest = reservation.getGuest();
                    if (guest.isHasBalance() == true) {
                        System.out.println("Please input your card information. [Correct Format example 1234567891234567]");
                        String cardInformation = stdInt.nextLine();
                        guest.setGuestCardNumber(cardInformation);
                        guest.setHasBalance(false);
                        reservation.setGuest(guest);
                        System.out.println("Thank you for Your credit card Info./n The balance has been paid.");
                    } else {
                        System.out.println("Thank you. The reservation has already been paid.");
                    }
                }
            }

        } catch (NullPointerException | InputMismatchException e) {
            System.out.println("The reservation ID is not valid.\nPlease try again.");
        }
        return guest;
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
