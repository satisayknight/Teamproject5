package hotelReservationSystem.hotel.room;

import hotelReservationSystem.bookingInfo.HotelReservation;
import hotelReservationSystem.hotel.room.types.RoomTypes;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomCatalogTest extends HotelReservation {
    private ICatalog catalog = new RoomCatalog();

    @Before
    //not working
    public void setUp() {
        ICatalog catalog = new RoomCatalog();
    }

    @Test
    void testGetNextRoomByType() {
        Room item1=catalog.getNextRoomByType(RoomTypes.KING);
        assertEquals("101", item1.getRoomNumber());
    }

    @Test
    void testFindByRoomNumber() {
        Room item1 = catalog.findByRoomNumber("101");
        assertEquals("101", item1.getRoomNumber());
    }

    @Test
    public void testFindByRoomNotExists() {
        assertNull(catalog.findByRoomNumber(String.valueOf(1001)));
    }

    @Test
    void testFindByRoomType() {
        Collection<Room> items = catalog.findByRoomType(RoomTypes.KING);

        List<Room> sortedItems = new ArrayList<>(items);

        assertEquals(20, sortedItems.size());
        assertEquals("101", sortedItems.get(0).getRoomNumber());
        assertEquals("102", sortedItems.get(1).getRoomNumber());

        Collection<Room> items2 = catalog.findByRoomType(RoomTypes.QUEEN);
        List<Room> sortedItems2 = new ArrayList<>(items2);

        assertEquals(20, sortedItems2.size());
        assertEquals("121", sortedItems2.get(0).getRoomNumber());
        assertEquals("122", sortedItems2.get(1).getRoomNumber());

        Collection<Room> items3 = catalog.findByRoomType(RoomTypes.SUITE);
        List<Room> sortedItems3 = new ArrayList<>(items3);

        assertEquals(20, sortedItems3.size());
        assertEquals("141", sortedItems3.get(0).getRoomNumber());
        assertEquals("142", sortedItems3.get(1).getRoomNumber());
    }

    @Test
    void testFindAvailableRoomByRoomType_with_All_rooms_Taken() {
        Collection<Room> items = catalog.findTakenRoomByRoomType(RoomTypes.KING);
        Collection<Room> ans = new ArrayList<>(items);
        Collection<Room> roomOfInterestedRoomType = catalog.findByRoomType(RoomTypes.KING);
        for (Room r : roomOfInterestedRoomType) {
            if (r.getIsVacant() == true) {
                r.changeToNotVacant();
                ans.add(r);
            }
        }
        Collection<Room> roomsTaken = catalog.findAvailableRoomByRoomType(RoomTypes.KING);
        assertEquals(0, roomsTaken.size());
    }

    @Test
    void testFindAvailableRoomByRoomType() {
        Collection<Room> items = catalog.findAvailableRoomByRoomType(RoomTypes.KING);
        List<Room> sortedItems = new ArrayList<>(items);
        assertEquals(20, sortedItems.size());
        assertEquals("101", sortedItems.get(0).getRoomNumber());
        assertEquals("102", sortedItems.get(1).getRoomNumber());
    }

    @Test
    void testFindTakenRoomByRoomType() {
        Collection<Room> items = catalog.findTakenRoomByRoomType(RoomTypes.KING);
        List<Room> sortedItems = new ArrayList<>(items);
        assertEquals(0, sortedItems.size());
    }

    @Test
    void testFindTakenRoomByRoomType_with_Taken_Room() {
        Collection<Room> items = catalog.findTakenRoomByRoomType(RoomTypes.KING);
        Collection<Room> ans = new ArrayList<>(items);
        Collection<Room> roomOfInterestedRoomType = catalog.findByRoomType(RoomTypes.KING);
        for (Room r : roomOfInterestedRoomType) {
            if (r.getIsVacant() == true) {
                r.changeToNotVacant();
                ans.add(r);
            }
        }
        assertEquals(20, ans.size());
    }

    @Test
    void testTotalNumberOfRooms() {
        int items = catalog.totalNumberOfRooms();
        assertEquals(60, items);
    }
}