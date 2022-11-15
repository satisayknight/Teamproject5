package hotelReservationSystem.hotel.room;

import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.util.Collection;

public interface ICatalog {

    /**
     * Returns the item with the room number,
     * or null if not found.
     */
    public Room findByRoomNumber(String roomNumber);

    /**
     * Returns the next available room with room type
     */
    public Room getNextRoomByType(RoomTypes roomType);

    /**
     * Returns a collection of rooms that are of
     * the supplied room type.
     */
    public Collection<Room> findByRoomType(RoomTypes roomType);

    /**
     * Returns a collection of available rooms that are of
     * the supplied room type.
     */
    public Collection<Room> findAvailableRoomByRoomType(RoomTypes roomType);

    /**
     * Returns a collection of taken rooms that are of
     * the supplied room type.
     */
    public Collection<Room> findTakenRoomByRoomType(RoomTypes roomType);

    /**
     * Size of the catalog.
     */
    public int totalNumberOfRooms();

    /**
     * Read-only view of the entire catalog.
     * See java.util.Collections class
     * (an all-static utility class) for help here.
     */
    public Collection<Room> getAll();




}
