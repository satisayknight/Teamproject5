package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;
import hotelReservationSystem.hotel.room.Room;
import hotelReservationSystem.hotel.room.types.RoomTypes;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryReservationCatalogTest {
    private Collection<HotelReservation> allHotelReservationItems;

    @Before
    public void setUp() throws Exception {
        InMemoryReservationCatalog catalog = new InMemoryReservationCatalog();
        Collection<HotelReservation> inMemoryAllHotelReservationItems = catalog.getAll();
        Guest testGuest;
        Room testRoom;
        HotelReservation allHotelReservationItems = new HotelReservation(1,
                new Guest("Joe", "joe@gmail.com", "4842138433"),
                new Room("101", RoomTypes.KING, true),
                4);
    }

    @Test
    public void createNewHotelReservation() {
        //Arrange
        //Act
        //Assume
    }

    @Test
    public void daysToBook() {
    }

    @Test
    public void createRoomForReservation() {
    }

    @Test
    public void payForReservation() {
    }

    @Test
    public void findById() {
    }
}