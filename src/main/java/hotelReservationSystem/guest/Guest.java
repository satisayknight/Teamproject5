package hotelReservationSystem.guest;

import hotelReservationSystem.guest.membership.MembershipTypes;

import java.util.List;

public class Guest {
    private String guestName;
    private String guestEmail;
    private String guestPhoneNumber;

    MembershipTypes membershipType = null;
    private List<Guest> guestList;

    public Guest() {

    }

    public Guest(String name, String email, String phone) {
        this.guestName = name;
        this.guestEmail = email;
        this.guestPhoneNumber = phone;
    }

    public Guest(String name, String email, String phone, MembershipTypes type) {
        this(name, email, phone);
        this.membershipType = type;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getGuestPhoneNumber() {
        return guestPhoneNumber;
    }

    public void setGuestPhoneNumber(String guestPhoneNumber) {
        this.guestPhoneNumber = guestPhoneNumber;
    }
}
