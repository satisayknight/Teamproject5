package hotelReservationSystem.hotel.room;

import hotelReservationSystem.bookingInfo.HotelReservation;
import hotelReservationSystem.bookingInfo.InMemoryReservationCatalog;
import hotelReservationSystem.hotel.room.types.RoomTypes;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomCatalogTest extends HotelReservation {

    private ICatalog catalog =  new RoomCatalog();

    @Before
    //not working
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
          Collection<Room> items = catalog.findByRoomType(RoomTypes.KING);
          // sort the results by id (for testing purposes)
          List<Room> sortedItems = new ArrayList<>(items);
          //sortedItems.sort();  // natural order (id)
          //System.out.println(sortedItems);
          assertEquals(20, sortedItems.size());
          assertEquals("101", sortedItems.get(0).getRoomNumber());
          assertEquals("102", sortedItems.get(1).getRoomNumber());

          Collection<Room> items2 = catalog.findByRoomType(RoomTypes.QUEEN);
          List<Room> sortedItems2 = new ArrayList<>(items2);
          //System.out.println(sortedItems2);
          assertEquals(20, sortedItems2.size());
          assertEquals("121", sortedItems2.get(0).getRoomNumber());
          assertEquals("122", sortedItems2.get(1).getRoomNumber());

          Collection<Room> items3 = catalog.findByRoomType(RoomTypes.SUITE);
          List<Room> sortedItems3 = new ArrayList<>(items3);
          //System.out.println(sortedItems2);
          assertEquals(20, sortedItems3.size());
          assertEquals("141", sortedItems3.get(0).getRoomNumber());
          assertEquals("142", sortedItems3.get(1).getRoomNumber());



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

}