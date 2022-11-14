package hotelReservationSystem.guest;

import java.util.List;
import java.util.regex.Pattern;

public class Guest {
    private String guestName;
    private String guestEmail;
    private String guestPhoneNumber;
    private String guestCardNumber;
    private static final String EMAIL_REGEX_PATTERN = "^(.+)@(.+).(.+)$";
    private static final String PHONE_REGEX_PATTERN = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    private static final String CREDITCARD_REGEX_PATTERN = "/^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$/";


    //MembershipTypes membershipType = null;

    public Guest() {
    }

    public Guest(String name, String email, String phone) {
        this.guestName = name;
        this.guestEmail = email;
        this.guestPhoneNumber = phone;
    }


    public void setGuestEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email");
        } else {
            this.guestEmail = email;
        }
    }

    public void setGuestPhoneNumber(String number) {
        Pattern pattern = Pattern.compile(PHONE_REGEX_PATTERN);

        if (!pattern.matcher(number).matches()) {
            throw new IllegalArgumentException("Invalid phone number");
        } else {
            this.guestPhoneNumber = number;
        }
    }

    public void setGuestName(String guestName) {
        if (guestName.length() == 0) {
            throw new IllegalArgumentException("Invalid name length");
        } else {
            this.guestName = guestName;
        }
    }

    public String getGuestCardNumber() {
        return guestCardNumber;
    }

    public void setGuestCardNumber(String guestCardNumber) {
        Pattern pattern = Pattern.compile(CREDITCARD_REGEX_PATTERN);
        if (!pattern.matcher(guestCardNumber).matches()) {
            throw new IllegalArgumentException("Invalid Card number");
        } else {
            this.guestCardNumber = guestCardNumber;
        }
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
                + " Phone Number: " + this.guestPhoneNumber;
    }


}