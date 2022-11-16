package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.hotel.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class HotelReservationTest extends HotelReservation {

    private Collection<HotelReservation> allHotelReservationItems;

    //Arrange
    //Assume
    //Act

    @BeforeEach
    void setUp() {
        InMemoryReservationCatalog catalog = new InMemoryReservationCatalog();
        allHotelReservationItems = catalog.getAll();
    }

    @Test
    void testGetDays() {
    }

    @Test
    void testSetDays() {
    }

    @Test
    void testGetGuest() {
    }

    @Test
    void testSetGuest() {
    }

    @Test
    void testSetRoom() {
    }

    @Test
    void testGetReservationId() {
    }

    @Test
    void testSetReservationId() {
    }

    @Test
    void testGetRoom() {
    }

    @Test
    void testGetTotalCost() {
    }

    @Test
    void testSetTotalCost() {
    }
}