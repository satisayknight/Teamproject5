package hotelReservationSystem.guest;

import hotelReservationSystem.bookingInfo.HotelReservation;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest extends HotelReservation {
    Guest guest;

    @Before
    void setUp() {
        Guest guest = new Guest("sar", "sa@gmail.com", "2099999999", true);
        //guest.setHasBalanceDue(false);

    }

    @Test
    void setHasBalanceDue() {

        //assertEquals(true, guest.getHasBalanceDue());

    }

    @Test
    void setGuestEmail() {

    }

    @Test
    void setGuestPhoneNumber() {
       Guest guest = new Guest();
        guest.setGuestPhoneNumber("1234567891");
        assertEquals("1234567891", guest.getGuestEmail());
    }

    @Test
    void setGuestName() {
        guest.setGuestCardNumber("2222222222222222");
        assertEquals("2222222222222222", guest.getGuestCardNumber());

    }

    @Test
    void setGuestCardNumber() {
        guest.setGuestCardNumber("2222222222222222");
        assertEquals("2222222222222222", guest.getGuestCardNumber());
    }

    @Test
    void getGuestName() {
        //guest.setGuestName("Sarthak");
        assertEquals("sar", guest.getGuestName());
    }

    @Test
    void getGuestEmail() {
        guest.setGuestEmail("test@mail.com");
        assertEquals("test@mail.com", guest.getGuestEmail());
    }

    @Test
    void getGuestPhoneNumber() {
        guest.setGuestPhoneNumber("1234567891");
        assertEquals("1234567891", guest.getGuestEmail());
    }

    @Test
    void getHasBalanceDue() {
        guest.setHasBalanceDue(false);
        assertEquals(false, guest.getHasBalanceDue());
    }

    @Test
    void getGuestCardNumber() {
    }
}

