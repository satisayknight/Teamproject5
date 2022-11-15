package hotelReservationSystem.hotel.room;

import hotelReservationSystem.bookingInfo.HotelReservation;
import hotelReservationSystem.bookingInfo.InMemoryReservationCatalog;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomCatalogTest extends HotelReservation {
    private InMemoryReservationCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryReservationCatalog();
    }

    @Test
    void getNextRoomByType() {
    }

    @Test
    void findByRoomNumber() {
        HotelReservation item1 = catalog.findById(101);
        assertEquals(Integer.valueOf(101), item1.getRoom());
    }


    @Test
    public void testFindByIdNotExists() {
         assertNull(catalog.findById(2000));
      }
    @Test
    void findByRoomType() {
    }

    @Test
    void findAvailableRoomByRoomType() {
    }

    @Test
    void findTakenRoomByRoomType() {
    }

    @Test
    void totalNumberOfRooms() {
    }

    @Test
    void getAll() {
    }

    @Test
    void testToString() {
    }
}