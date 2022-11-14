package hotelReservationSystem.hotel;

import hotelReservationSystem.bookingInfo.HotelReservation;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.util.Scanner;

public class Hotel {

    private static final int totalNumberOfAvailableKingRoom=20;
    private static final int totalNumberOfAvailableQueenRoom=20;
    private static final int totalNumberOfAvailableSuite=20;

    private Room room;

    public void booking(){

    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void makeReservation(){

        Scanner stdInt = new Scanner(System.in);
        Room[] amountOfRoomsRequested;
        int selection = 0;

        do {
            displayMenu();

            System.out.print("Enter your selection: ");
            selection = stdInt.nextInt();

            switch (selection) {

                case 1:
                    System.out.println("Which room would you like to book? 1:King 2:Queen or 3:Suite");
                    int roomType = stdInt.nextInt();
                    HotelReservation hotelReservation = new HotelReservation();
                    if (roomType == 1) {
                        hotelReservation.createANewRoomReservation(RoomTypes.KING);
                    } else if (roomType == 2) {

                    } else if (roomType == 3) {

                    } else {
                        System.out.println("Invalid. Please input: 1, 2, or 3.");
                    }
                    break;

                case 2:
                    System.out.println("What is your reservation id? ");
                    int checkInByReservationId = stdInt.nextInt();
                    break;

                case 3:
                    System.out.println("What is your reservation id? ");
                    int viewReservationDetailsById = stdInt.nextInt();
                    break;

                case 4:
                    System.out.println("Which kind of room would you like to view? 1:King, 2:Queen, or 3:Suite? ");
                    int roomTypeToView = stdInt.nextInt();
                    if (roomTypeToView == 1) {
                        System.out.println("Type:King Beds:1 Max Capacity:4 Price:200 Amenities:Full Kitchen");
                    } else if (roomTypeToView == 2) {
                        System.out.println("Type:Queen Beds:2 Max Capacity:6 Price:150 Amenities:Half Kitchen");
                    } else if (roomTypeToView == 3) {
                        System.out.println("Type:Suite Beds:1 Max Capacity:4 Price:100 Amenities:Microwave");
                    } else {
                        System.out.println("Invalid. Please input: 1, 2, or 3.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the HotelReservationSystem JSS program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        while (selection != 5);
    }

    public static void displayMenu() {
        System.out.println("MENU: ");
        System.out.println("1: Create a new reservation.");
        System.out.println("2: Check in or check out.");
        System.out.println("3: View your reservation details.");
        System.out.println("4: View available room details.");
        System.out.println("5: Exit program.");
    }




}
