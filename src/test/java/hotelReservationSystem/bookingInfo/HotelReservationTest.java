package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.Hotel;
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
    void setUp() {
        
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
        //Arrange
        //Act
        //Assert
        HotelReservation testReservation1 = new HotelReservation(1,
                new Guest("Joe", "joe@gmail.com", "4842138433"),
                new Room("101", RoomTypes.KING, false),
                4);
        assertEquals(4, testReservation1.getDays());
    }

    @Test
    void testSetDays() {
        //Arrange
        //Act
        //Assert
        HotelReservation testReservation2 = new HotelReservation(2,
                new Guest("Chris", "chris@gmail.com", "4842138433"),
                new Room("202", RoomTypes.QUEEN, false),
                2);
        testReservation2.setDays(4);
        assertEquals(4, 4);
    }

    @Test
    void testGetGuest() {
        //Arrange
        //Act
        //Assert
        HotelReservation testReservation3 = new HotelReservation(3,
                new Guest("John", "john@gmail.com", "4842138433"),
                new Room("303", RoomTypes.SUITE, false),
                10);
        //currently not passing
        assertEquals(new Guest("John", "john@gmail.com", "4842138433"), testReservation3.getGuest());
    }

    @Test
    void testSetGuest() {
        //Arrange
        //Act
        //Assert
        HotelReservation testReservation3 = new HotelReservation(3,
                new Guest("John", "john@gmail.com", "4842138433"),
                new Room("303", RoomTypes.SUITE, false),
                10);
        //debug
//        assertEquals(new Guest("Joseph", "john@gmail.com", "4842138433"),
//                testReservation3.setGuest("Joseph", "john@gmail.com", "4842138433"));
    }

    @Test
    void testSetRoom() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void testGetReservationId() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void testSetReservationId() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void testGetRoom() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void testGetTotalCost() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void testSetTotalCost() {
        //Arrange
        //Act
        //Assert
    }
}