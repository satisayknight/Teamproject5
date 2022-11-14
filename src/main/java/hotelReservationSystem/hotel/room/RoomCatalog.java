package hotelReservationSystem.hotel.room;

import hotelReservationSystem.hotel.room.types.RoomTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoomCatalog implements ICatalog{


    private List<Room> catalogOfRooms = new ArrayList<>(List.of(
            /* roomNumber    roomType*/
            new Room("101", RoomTypes.KING,true),
            new Room("102", RoomTypes.KING,true),
            new Room("103", RoomTypes.KING,true),
            new Room("104", RoomTypes.KING,true),
            new Room("105", RoomTypes.KING,true),
            new Room("106", RoomTypes.KING,true),
            new Room("107", RoomTypes.KING,true),
            new Room("108", RoomTypes.KING,true),
            new Room("109", RoomTypes.KING,true),
            new Room("110", RoomTypes.KING,true),
            new Room("111", RoomTypes.KING,true),
            new Room("112", RoomTypes.KING,true),
            new Room("113", RoomTypes.KING,true),
            new Room("114", RoomTypes.KING,true),
            new Room("115", RoomTypes.KING,true),
            new Room("116", RoomTypes.KING,true),
            new Room("117", RoomTypes.KING,true),
            new Room("118", RoomTypes.KING,true),
            new Room("119", RoomTypes.KING,true),
            new Room("120", RoomTypes.KING,true),
            new Room("121", RoomTypes.QUEEN,true),
            new Room("122", RoomTypes.QUEEN,true),
            new Room("123", RoomTypes.QUEEN,true),
            new Room("124", RoomTypes.QUEEN,true),
            new Room("125", RoomTypes.QUEEN,true),
            new Room("126", RoomTypes.QUEEN,true),
            new Room("127", RoomTypes.QUEEN,true),
            new Room("128", RoomTypes.QUEEN,true),
            new Room("129", RoomTypes.QUEEN,true),
            new Room("130", RoomTypes.QUEEN,true),
            new Room("131", RoomTypes.QUEEN,true),
            new Room("132", RoomTypes.QUEEN,true),
            new Room("133", RoomTypes.QUEEN,true),
            new Room("134", RoomTypes.QUEEN,true),
            new Room("135", RoomTypes.QUEEN,true),
            new Room("136", RoomTypes.QUEEN,true),
            new Room("137", RoomTypes.QUEEN,true),
            new Room("138", RoomTypes.QUEEN,true),
            new Room("139", RoomTypes.QUEEN,true),
            new Room("140", RoomTypes.QUEEN,true),
            new Room("141", RoomTypes.SUITE,true),
            new Room("142", RoomTypes.SUITE,true),
            new Room("143", RoomTypes.SUITE,true),
            new Room("144", RoomTypes.SUITE,true),
            new Room("145", RoomTypes.SUITE,true),
            new Room("146", RoomTypes.SUITE,true),
            new Room("147", RoomTypes.SUITE,true),
            new Room("148", RoomTypes.SUITE,true),
            new Room("149", RoomTypes.SUITE,true),
            new Room("150", RoomTypes.SUITE,true),
            new Room("151", RoomTypes.SUITE,true),
            new Room("152", RoomTypes.SUITE,true),
            new Room("153", RoomTypes.SUITE,true),
            new Room("154", RoomTypes.SUITE,true),
            new Room("155", RoomTypes.SUITE,true),
            new Room("156", RoomTypes.SUITE,true),
            new Room("157", RoomTypes.SUITE,true),
            new Room("158", RoomTypes.SUITE,true),
            new Room("159", RoomTypes.SUITE,true),
            new Room("160", RoomTypes.SUITE,true)

    )
    );

    public Room getNextRoomByType(RoomTypes roomType) {
        List<Room> availableRoomByRoomType = findAvailableRoomByRoomType(roomType);
        return availableRoomByRoomType.get(0);
    }

    @Override
    public Room findByRoomNumber(String roomNumber) {

        for (Room r : catalogOfRooms) {
            if (r.getRoomNumber().equals(roomNumber)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Collection<Room> findByRoomType(RoomTypes roomType) {
        Collection<Room> ans = new ArrayList<>();
        for (Room r : catalogOfRooms) {
            if (r.getRoomTypes().equals(roomType)) {
                ans.add(r);
            }
        }
        return ans;
    }

    public List<Room> findAvailableRoomByRoomType(RoomTypes roomType){

        List<Room> ans = new ArrayList<>();
        Collection<Room> roomOfInterestedRoomType = findByRoomType(roomType);
        for (Room r : roomOfInterestedRoomType) {
            if (r.getIsVacant()==true ) {
                ans.add(r);
            }
        }
        return ans;
    }
    public Collection<Room> findTakenRoomByRoomType(RoomTypes roomType){

        Collection<Room> ans = new ArrayList<>();
        Collection<Room> roomOfInterestedRoomType = findByRoomType(roomType);
        for (Room r : roomOfInterestedRoomType) {
            if (r.getIsVacant()==false ) {
                ans.add(r);
            }
        }
        return ans;
    }


    @Override
    public int totalNumberOfRooms() {
        return catalogOfRooms.size();
    }

    @Override
    public Collection<Room> getAll() {
        return catalogOfRooms;
    }
}
