package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.Hotel;
import hotelReservationSystem.hotel.room.BalanceCalculator;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.types.RoomTypes;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelReservationTest extends HotelReservation {
    private Collection<HotelReservation> allHotelReservationItems;

    @Before
    public void setUp() throws Exception {
        HotelReservation testReservation1 = new HotelReservation(1,
                new Guest("Joe", "joe@gmail.com", "4842138433"),
                new Room("101", RoomTypes.KING, false),
                4);
        allHotelReservationItems.add(testReservation1);
        HotelReservation testReservation2 = new HotelReservation(2,
                new Guest("Chris", "chris@gmail.com", "4842138433"),
                new Room("202", RoomTypes.QUEEN, false),
                2);
        allHotelReservationItems.add(testReservation2);
        HotelReservation testReservation3 = new HotelReservation(3,
                new Guest("John", "john@gmail.com", "4842138433"),
                new Room("303", RoomTypes.SUITE, false),
                10);
        allHotelReservationItems.add(testReservation3);
    }

    @Test
    void testGetDays() {
        HotelReservation testReservation1 = new HotelReservation(1,
                new Guest("Joe", "joe@gmail.com", "4842138433"),
                new Room("101", RoomTypes.KING, false),
                4);
        assertEquals(4, testReservation1.getDays());
    }

    @Test
    void testSetDays() {
        HotelReservation testReservation2 = new HotelReservation(2,
                new Guest("Chris", "chris@gmail.com", "4842138433"),
                new Room("202", RoomTypes.QUEEN, false),
                2);
        testReservation2.setDays(4);
        assertEquals(4, 4);
    }

    @Test
    void testGetGuest() {
        HotelReservation testReservation3 = new HotelReservation(3,
                new Guest("John", "john@gmail.com", "4842138433"),
                new Room("303", RoomTypes.SUITE, false),
                10);
        assertEquals(new Guest("John", "john@gmail.com", "4842138433"), testReservation3.getGuest());
    }

    @Test
    void testSetGuest() {
        Guest testGuest = new Guest("John", "john@gmail.com", "4842138433");
        HotelReservation testReservation1 = new HotelReservation ();
        testReservation1.setGuest(testGuest);
        assertEquals(new Guest("John", "john@gmail.com", "4842138433"),
                testGuest);
    }

    @Test
    void testSetRoom() {
        Room roomTest = new Room("303", RoomTypes.SUITE, false);
        HotelReservation testReservation1 = new HotelReservation ();
        testReservation1.setRoom(roomTest);
assertEquals(new Room("303", RoomTypes.SUITE, false)
        ,testReservation1.getRoom());
    }

    @Test
    void testGetReservationId() {
        HotelReservation testReservation3 = new HotelReservation(3,
                new Guest("John", "john@gmail.com", "4842138433"),
                new Room("303", RoomTypes.SUITE, false),
                10);
        assertEquals(3, testReservation3.getReservationId());
    }

    @Test
    void testSetReservationId() {
        HotelReservation testReservation3 = new HotelReservation(3,
                new Guest("John", "john@gmail.com", "4842138433"),
                new Room("303", RoomTypes.SUITE, false),
                10);
        testReservation3.setReservationId(5);
        assertEquals(5, testReservation3.getReservationId());
    }

    @Test
    void testGetTotalCost() {
        BalanceCalculator testPrice = new BalanceCalculator();
        HotelReservation testReservation3 = new HotelReservation(3,
                new Guest("John", "john@gmail.com", "4842138433"),
                new Room("303", RoomTypes.SUITE, false),
                10);
        double testTotalCost = testPrice.calculateCosts(testReservation3.getRoom().getRoomTypes(),
                testReservation3.getDays());
        testReservation3.setTotalCost(testTotalCost);
        assertEquals(5000, testReservation3.getTotalCost());
    }

    @Test
    void testSetTotalCost() {
        BalanceCalculator testPrice = new BalanceCalculator();
        HotelReservation testReservation3 = new HotelReservation(3,
                new Guest("John", "john@gmail.com", "4842138433"),
                new Room("303", RoomTypes.SUITE, false),
                10);
        testReservation3.setTotalCost(5000);
        assertEquals(5000, testReservation3.getTotalCost());
    }
}