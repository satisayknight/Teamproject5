package hotelReservationSystem.hotel.room;

import hotelReservationSystem.bookingInfo.HotelReservation;
import org.junit.Before;

import javax.xml.catalog.Catalog;

import static org.junit.jupiter.api.Assertions.*;

class ICatalogTest extends HotelReservation {

    private Catalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @org.junit.jupiter.api.Test
    void findByRoomNumber() {
    }

    @org.junit.jupiter.api.Test
    void getNextRoomByType() {
    }

    @org.junit.jupiter.api.Test
    void findByRoomType() {
    }

    @org.junit.jupiter.api.Test
    void findAvailableRoomByRoomType() {
    }

    @org.junit.jupiter.api.Test
    void findTakenRoomByRoomType() {
    }

    @org.junit.jupiter.api.Test
    void totalNumberOfRooms() {
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }
}