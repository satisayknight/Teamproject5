package hotelReservationSystem.guest;

import hotelReservationSystem.bookingInfo.HotelReservation;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest extends HotelReservation {


    @Test
    void testSetHasBalanceDu_PositiveTesting() {
        Guest guest = new Guest();
        //Hasbalance should be true when guest is created
        assertEquals(true, guest.getHasBalanceDue());

        guest.setHasBalanceDue(false);
        assertEquals(false, guest.getHasBalanceDue());
    }

    @Test
    void testSetGuestEmail_PositiveTesting() {
        Guest guest = new Guest();
        guest.setGuestEmail("sa@mail.com");
        assertEquals("sa@mail.com", guest.getGuestEmail());
    }

    @Test
    void testSetGuestEmail_NegativeTesting() throws IllegalArgumentException {
        Guest guest = new Guest();
        try {
            guest.setGuestEmail("samail.com");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid email", e.getMessage());
        }
        try {
            guest.setGuestEmail("2");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid email", e.getMessage());
        }
        try {
            guest.setGuestEmail("32e5731e5");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid email", e.getMessage());
        }
    }

    @Test
    void testSetGuestPhoneNumber_PositiveTesting() {
        Guest guest = new Guest();
        guest.setGuestPhoneNumber("2068225294");
        assertEquals("2068225294", guest.getGuestPhoneNumber());
    }

    @Test
    void testSetGuestPhoneNumber_NegativeTesting() throws IllegalArgumentException {
        Guest guest = new Guest();

        try {
            guest.setGuestPhoneNumber("1");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid phone number. Please input 10 digits.", e.getMessage());
        }

        try {
            guest.setGuestPhoneNumber("");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid phone number. Please input 10 digits.", e.getMessage());
        }

        try {
            guest.setGuestPhoneNumber("k");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid phone number. Please input 10 digits.", e.getMessage());
        }

        try {
            guest.setGuestPhoneNumber("11111111111111111111111111111111111111");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid phone number. Please input 10 digits.", e.getMessage());
        }

    }


    @Test
    void testSetGuestName_PositiveTesting() {
        Guest guest = new Guest();
        guest.setGuestName("Sar");
        assertEquals("Sar", guest.getGuestName());

        guest.setGuestName("Sar Singh");
        assertEquals("Sar Singh", guest.getGuestName());
    }

    @Test
    void testSetGuestName_NegativeTesting() throws IllegalArgumentException {
        Guest guest = new Guest();
        try {
            guest.setGuestName("");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid name", e.getMessage());
        }
        try {
            guest.setGuestName("Sar");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid name", e.getMessage());
        }
        try{guest.setGuestName("123");}
        catch (IllegalArgumentException e){
            assertEquals("Invalid name",e.getMessage());
        }
    }

    @Test
    void testSetGuestCardNumber_PositiveTesting() {
        Guest guest = new Guest();
        guest.setGuestCardNumber("1234567890123456");
        assertEquals("1234567890123456", guest.getGuestCardNumber());
    }

    @Test
    void testSetGuestCardNumber_NegativeTesting() throws IllegalArgumentException {
        Guest guest = new Guest();
        try {
            guest.setGuestCardNumber("2");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Card number", e.getMessage());
        }
        try {
            guest.setGuestCardNumber("typing String");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Card number", e.getMessage());
        }

    }


}