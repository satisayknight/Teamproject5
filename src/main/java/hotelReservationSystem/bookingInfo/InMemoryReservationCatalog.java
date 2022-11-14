package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.hotel.Hotel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InMemoryReservationCatalog implements IReservationCatalog {

    private List<HotelReservation> hotelReservationList;

    public HotelReservation createNewHotelReservation() {
        HotelReservation reservation = new HotelReservation();
        return reservation;
    }

    @Override
    public HotelReservation findById(int id) {
        HotelReservation result = null;

        for (HotelReservation reservation : hotelReservationList) {
            if (reservation.getReservationId() == id) {
                result = reservation;
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return hotelReservationList.size();
    }

    @Override
    public Collection<HotelReservation> getAll() {
        return Collections.unmodifiableCollection(hotelReservationList);
    }
}
