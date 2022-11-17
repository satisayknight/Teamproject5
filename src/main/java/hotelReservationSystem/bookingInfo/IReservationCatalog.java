package hotelReservationSystem.bookingInfo;

import hotelReservationSystem.guest.Guest;

import java.util.Collection;

public interface IReservationCatalog {
    public void findById(int id);
    public int size();
    public Collection<HotelReservation> getAll();
    public void createNewHotelReservation();
    public void payForReservation();
    public void startDateToBook();
    public void daysToBook();
    public void createRoomForReservation();
    public void createGuestForReservation();

}
