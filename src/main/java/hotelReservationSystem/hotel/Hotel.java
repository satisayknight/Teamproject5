package hotelReservationSystem.hotel;

import hotelReservationSystem.bookingInfo.HotelReservation;
import hotelReservationSystem.bookingInfo.InMemoryReservationCatalog;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.util.Scanner;

public class Hotel {

    private static final int totalNumberOfAvailableKingRoom=20;
    private static final int totalNumberOfAvailableQueenRoom=20;
    private static final int totalNumberOfAvailableSuite=20;

    public void operate(){

        Scanner stdInt = new Scanner(System.in);
        int selection = 0;

        do {
            displayMenu();
            InMemoryReservationCatalog hotelReservation = new InMemoryReservationCatalog();

            System.out.print("Enter your selection: ");
            selection = stdInt.nextInt();

            switch (selection) {

                case 1:
                    hotelReservation.createNewHotelReservation();
                    break;

                case 2:
                    System.out.println("What is your reservation id? ");
                    int viewReservationDetailsById = stdInt.nextInt();
                    hotelReservation.findById(viewReservationDetailsById);
                    break;

                case 3:
                    System.out.println("Which kind of room would you like to view? 1:King, 2:Queen, or 3:Suite? ");
                    int roomTypeToView = stdInt.nextInt();
                    if (roomTypeToView == 1) {
                        System.out.println("Type:King Beds:1 Max Capacity:4 Price:$200");
                    } else if (roomTypeToView == 2) {
                        System.out.println("Type:Queen Beds:2 Max Capacity:6 Price:$150");
                    } else if (roomTypeToView == 3) {
                        System.out.println("Type:Suite Beds:2 Max Capacity:8 Price:$500");
                    } else {
                        System.out.println("Invalid. Please input: 1, 2, or 3.");
                    }
                    break;

                case 4:
                    hotelReservation.payForReservation();
                    break;

                case 9:
                    System.out.println("Thank you for using the HotelReservationSystem JSS program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        while (selection != 4);
    }

    public static void displayMenu() {
        System.out.println("MENU: ");
        System.out.println("1: Create a new reservation.");
        System.out.println("2: View your reservation details.");
        System.out.println("3: View available room details.");
        System.out.println("4: Pay for reservation.");
        System.out.println("9: Exit program.");
    }




}
