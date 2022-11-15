package hotelReservationSystem.hotel.room;

import hotelReservationSystem.bookingInfo.HotelReservation;
import hotelReservationSystem.bookingInfo.InMemoryReservationCatalog;
import org.junit.Before;

import javax.xml.catalog.Catalog;

import static org.junit.jupiter.api.Assertions.*;

class ICatalogTest extends HotelReservation {

    private InMemoryReservationCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryReservationCatalog();
    }



    @org.junit.jupiter.api.Test
    void findByRoomNumber() {
        HotelReservation item1 = catalog.findById(101);
        assertEquals(Integer.valueOf(1), item1.getRoom());
    }

    @org.junit.jupiter.api.Test
    public void testFindByIdNotExists() {
        assertNull(catalog.findById(2000));
    }

  // @org.junit.jupiter.api.Test
  // void getNextRoomByType() {
  // }

 // @org.junit.jupiter.api.Test
 // void findByRoomType() {
 // }

  // @org.junit.jupiter.api.Test
  // void findAvailableRoomByRoomType() {
  // }

  // @org.junit.jupiter.api.Test
  // void findTakenRoomByRoomType() {
  // }

  // @org.junit.jupiter.api.Test
  // void totalNumberOfRooms() {
  // }

  // @org.junit.jupiter.api.Test
  // void getAll() {
  // }
}