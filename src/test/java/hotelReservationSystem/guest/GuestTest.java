package hotelReservationSystem.guest;

import hotelReservationSystem.bookingInfo.HotelReservation;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest extends HotelReservation {

    @Before
    void setUp(){
        //Guest guest= new Guest("sar","sa@gmail.com","2099999999",true);
        //guest.setHasBalanceDue(false);

    }

    @Test
    void setHasBalanceDue() {
        Guest guest = new Guest();
        guest.setHasBalanceDue(false);
        assertEquals(false, guest.getHasBalanceDue());

    }

    @Test
    void setGuestEmail() {
    }

    @Test
    void setGuestPhoneNumber() {
    }

    @Test
    void setGuestName() {
    }

    @Test
    void setGuestCardNumber() {
    }

    @Test
    void getGuestName() {
    }

    @Test
    void getGuestEmail() {
    }

    @Test
    void getGuestPhoneNumber() {
    }

    @Test
    void getHasBalanceDue() {
    }

    @Test
    void getGuestCardNumber() {
    }
}