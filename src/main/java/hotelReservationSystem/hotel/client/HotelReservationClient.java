package hotelReservationSystem.hotel.client;

import hotelReservationSystem.bookingInfo.HotelReservation;
import hotelReservationSystem.hotel.Hotel;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.lang.reflect.Type;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationClient {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        hotel.makeReservation();

    }
}
