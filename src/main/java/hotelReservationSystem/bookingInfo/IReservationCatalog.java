package hotelReservationSystem.bookingInfo;

import java.util.Collection;

public interface IReservationCatalog {
    public HotelReservation findById(int id);
    public int size();
    public Collection<HotelReservation> getAll();
}
