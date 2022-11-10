package hotelReservationSystem.guest;

import hotelReservationSystem.guest.membership.MembershipTypes;

import java.util.List;
import java.util.regex.Pattern;

public class Guest {
    private String guestName;
    private String guestEmail;
    private String guestPhoneNumber;
    private static final String EMAIL_REGEX_PATTERN = "^(.+)@(.+).(.+)$";

    MembershipTypes membershipType = null;
    private List<Guest> guestList;

    public Guest() {
    }

    public Guest(String name, String email, String phone) {
        this.isValidEmail(email);
        this.guestName = name;
        this.guestEmail = email;
        this.guestPhoneNumber = phone;

    }
    private void isValidEmail(final String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);

        if(!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
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
    @Override
    public String toString() {
        return "Guest Name: " + this.guestName
                + " Email: " + this.guestEmail
                +"Phone Number: " + this.guestPhoneNumber;
    }
}
