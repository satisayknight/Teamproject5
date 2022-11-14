package hotelReservationSystem.hotel.client;

import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.lang.reflect.Type;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationClient {

    public static void main(String[] args) {
        Scanner stdInt = new Scanner(System.in);
        Room[] amountOfRoomsRequested;
        int selection = 0;

        do {
            displayMenu();

            System.out.println("Enter your selection: ");
            selection = stdInt.nextInt();

            switch (selection) {

                case 1:
                    System.out.println("How many rooms would you like to book? ");
                    int rooms = stdInt.nextInt();
                    amountOfRoomsRequested = new Room[rooms];

                    for (int i = 0; i < amountOfRoomsRequested.length; i++) {
                        System.out.println("What kind of room would you like: King, Queen, or Suite? ");
                        RoomTypes.Rooms roomTypesRequested = RoomTypes.Rooms.getByName(stdInt.nextLine().toUpperCase());
                    }

                case 2:
                    System.out.println("What is your reservation id? ");
                    int reservationId = stdInt.nextInt();
                    break;
                case 3:
                    System.out.println("What is your reservation id? ");
                    int updateReservationId = stdInt.nextInt();
                    break;
                case 4:
                    System.out.println("Which kind of room would you like to view? King, Queen, or Suite? ");
                    String roomTypeToView = stdInt.nextLine();
                    if (roomTypeToView.equalsIgnoreCase("King")) {

                    } else if (roomTypeToView.equalsIgnoreCase("Queen")) {

                    } else if (roomTypeToView.equalsIgnoreCase("Suite")) {

                    } else {
                        System.out.println("Invalid. Please input: King, Queen, or Suite.");
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
        System.out.println("3: Update an existing reservation.");
        System.out.println("4: View available room details.");
        System.out.println("5: Exit program.");
    }

}
