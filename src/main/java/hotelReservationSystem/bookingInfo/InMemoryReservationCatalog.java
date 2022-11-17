package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.room.BalanceCalculator;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.RoomCatalog;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class InMemoryReservationCatalog implements IReservationCatalog {
    Scanner stdInt = new Scanner(System.in);
    final static int MIN_DAYS_FOR_BOOKING = 1;
    final static int MAX_DAYS_FOR_BOOKING = 15;
    private static int counter = 0;
    private static List<HotelReservation> hotelReservationList = new ArrayList<>();
    private static RoomCatalog availableRooms = new RoomCatalog();
    Guest guestForBooking = new Guest();
    HotelReservation reservation = new HotelReservation();
    BalanceCalculator bookingTotalCost = new BalanceCalculator();
    Room roomReserved = new Room();

    @Override
    public void createNewHotelReservation() throws IllegalArgumentException, InputMismatchException {
        try {
            //Increment counter by 1 for every hotel reservation made for unique reservationId
            counter = counter + 1;

            //Set Room object for this reservation
            createRoomForReservation();

            //Set Guest object for this reservation
            createGuestForReservation();

            //Set Start Date for this reservation
            startDateToBook();

            //Days stayed
            daysToBook();

            //Set reservationId
            reservation.setReservationId(counter);

            //Calculate totalCost for reservation
            double totalCostOfThisReservation = bookingTotalCost.calculateCosts(
                    reservation.getRoom().getRoomTypes(), reservation.getDays());
            reservation.setTotalCost(totalCostOfThisReservation);

            //Display details
            System.out.println("Your reservation is successful. The reservation information:");
            System.out.println(reservation.toString());

            //change the reserved room to taken:
            roomReserved.changeToNotVacant();
            reservation.setRoom(roomReserved);

            //Add this reservation to the list of reservations
            hotelReservationList.add(reservation);
        } catch (InputMismatchException e) {
            System.out.print("Wrong Input. Please provide valid value from the menu selection.\n");
        }

    }

    @Override
    public void startDateToBook(){
        try{
            System.out.println("What is the start date for your room reservation? [Correct Format example 2022-10-10]");
            LocalDate startDate=LocalDate.parse(stdInt.nextLine());
            reservation.setStartDate(startDate);
        }catch (DateTimeParseException e){
            System.out.println("Please input a correct date [Correct Format example 2022-10-10]");
            startDateToBook();
        }


    }

    @Override
    public void daysToBook() {
        boolean isValidDays = false;
        while (!isValidDays) {
            System.out.println("How many days would you like to book for? It has to be between 1 and 15 days.");
            int daysToBook = stdInt.nextInt();
            if (daysToBook < MIN_DAYS_FOR_BOOKING || daysToBook > MAX_DAYS_FOR_BOOKING) {
                System.out.println("Please input a valid number of days to book.");
            } else {
                isValidDays = true;
                reservation.setDays(daysToBook);
                reservation.setEndDate(daysToBook);
            }
        }

    }

    @Override
    public void createRoomForReservation() throws IllegalArgumentException, InputMismatchException {

        try {
            //Set roomType and set Room based on user inputs
            System.out.println("Which room would you like to book? 1:King  2:Queen  3:Suite");
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
            }
            else {
                System.out.println("Invalid. Please input 1, 2, or 3.");
                //find a way to re-prompt this question instead of restarting the entire program
                createRoomForReservation();
            }
        } catch (InputMismatchException |IllegalArgumentException e) {
            System.out.println("Illegal Input - Please try Again");
            //createRoomForReservation();
            throw new InputMismatchException("This is an input mismatch handling message.");
        }

    }

    @Override
    public void createGuestForReservation() throws IllegalArgumentException, InputMismatchException {
        try {
            //Get Guest info from user inputs and set to Guest object
            stdInt.nextLine();
            System.out.println("What is your name?");
            Guest guestNameToBook = guestForBooking;
            guestNameToBook.setGuestName(stdInt.nextLine());
            System.out.println("What is your email?");
            Guest guestEmailToBook = guestForBooking;
            guestEmailToBook.setGuestEmail(stdInt.nextLine());
            System.out.println("What is your phone number? [Correct Format example 2021234567] ");
            Guest guestPhoneNumberToBook = guestForBooking;
            guestPhoneNumberToBook.setGuestPhoneNumber(stdInt.nextLine());
            reservation.setGuest(guestForBooking);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.print("Wrong Input\n");
            System.out.println("Press 'Enter' To Restart");
            createGuestForReservation();
        }

    }

    @Override
    public void payForReservation() throws IllegalArgumentException, InputMismatchException, NullPointerException {
        System.out.println("What is your reservation ID?");
        int reservationId = stdInt.nextInt();
        stdInt.nextLine();
        Guest guest = null;
        boolean idFound = false;
        try {
            for (HotelReservation reservation : hotelReservationList) {
                if (reservation.getReservationId() == reservationId) {
                    idFound = true;
                    guest = reservation.getGuest();
                    if (guest.getHasBalanceDue() == true) {
                        System.out.println("Please input your card information. " +
                                "[Correct Format example 1234123412341234]");
                        String cardInformation = stdInt.nextLine();
                        guest.setGuestCardNumber(cardInformation);
                        guest.setHasBalanceDue(false);
                        reservation.setGuest(guest);
                        System.out.println("Thank you for Your credit card Information." +
                                "\n The balance has been paid.");
                    } else {
                        System.out.println("Thank you. The reservation has already been paid.");
                    }
                }
            }
            if(!idFound)
                System.out.println("The Reservation ID is not found.\nPlease try again.");

        } catch (NullPointerException | InputMismatchException | IllegalArgumentException e) {
            System.out.println("The information is incorrect.\nPlease try again.");
        }

    }


    @Override
    public void findById(int id) throws NullPointerException, InputMismatchException {
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
