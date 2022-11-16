package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;

import java.util.Collection;

public interface IReservationCatalog {
    public HotelReservation findById(int id);
    public int size();
    public Collection<HotelReservation> getAll();
    public HotelReservation createNewHotelReservation();
    public void payForReservation();
}
