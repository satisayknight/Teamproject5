package hotelReservationSystem.hotel.room;

import hotelReservationSystem.bookingInfo.HotelReservation;
import hotelReservationSystem.bookingInfo.InMemoryReservationCatalog;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomCatalogTest extends HotelReservation {

    private ICatalog catalog =  new RoomCatalog();;

    @Before
    public void setUp() {catalog =  new RoomCatalog();
    }

    @Test
    void getNextRoomByType() {
    }

    @Test
    void findByRoomNumber() {
        Room item1 = catalog.findByRoomNumber("101");

        assertEquals("101", item1.getRoomNumber());
    }


    @Test
    public void testFindByRoomNotExists() {
         assertNull(catalog.findByRoomNumber(String.valueOf(1001)));
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