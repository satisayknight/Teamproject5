package hotelReservationSystem.guest;

import hotelReservationSystem.guest.membership.MembershipTypes;

import java.util.List;
import java.util.regex.Pattern;

public class Guest {
    private String guestName;
    private String guestEmail;
    private String guestPhoneNumber;
    private static final String EMAIL_REGEX_PATTERN = "^(.+)@(.+).(.+)$";
    private static final String PHONE_REGEX_PATTTERN = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";

    MembershipTypes membershipType = null;

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

    private void setGuestEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
        if(!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
        else {
            this.guestEmail = email;
        }
    }

    private void setGuestPhoneNumber(String number) {
        Pattern pattern = Pattern.compile(PHONE_REGEX_PATTTERN);

        if(!pattern.matcher(number).matches()) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        else {
            this.guestPhoneNumber = number;
        }
    }

    public void setGuestName(String guestName) {
        if (guestName.length() >= 0) {
            throw new IllegalArgumentException("Invalid name length");
        }
        else {
            this.guestName = guestName;
        }
    }

    public MembershipTypes getMembershipType() {
        return membershipType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public String getGuestPhoneNumber() {
        return guestPhoneNumber;
    }

    @Override
    public String toString() {
        return "Guest Name: " + this.guestName
                + " Email: " + this.guestEmail
                +"Phone Number: " + this.guestPhoneNumber;
    }
}