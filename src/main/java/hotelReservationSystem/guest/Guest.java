package hotelReservationSystem.guest;

import java.util.regex.Pattern;

public class Guest {
    //Constants for validation
    private static final String EMAIL_REGEX_PATTERN = "^(.+)@(.+).(.+)$";
    private static final String PHONE_REGEX_PATTERN = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    private static final String CREDITCARD_REGEX_PATTERN = "([0-9]{4})([0-9]{4})([0-9]{4})([0-9]{4})$";

    private String guestName;
    private String guestEmail;
    private String guestPhoneNumber;
    private String guestCardNumber;
    private boolean hasBalanceDue = true;

    public Guest() {
    }

    public Guest(String name, String email, String phone) {
        this.guestName = name;
        this.guestEmail = email;
        this.guestPhoneNumber = phone;
    }

    public void setHasBalanceDue(boolean hasBalance) {
        this.hasBalanceDue = hasBalance;
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

    public void setGuestCardNumber(String guestCardNumber) {
        Pattern pattern = Pattern.compile(CREDITCARD_REGEX_PATTERN);
        if (!pattern.matcher(guestCardNumber).matches()) {
            throw new IllegalArgumentException("Invalid Card number");
        } else {
            this.guestCardNumber = guestCardNumber;
            setHasBalanceDue(false);
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

    public boolean getHasBalanceDue() {
        return hasBalanceDue;
    }

    public String getGuestCardNumber() {
        return guestCardNumber;
    }

    @Override
    public String toString() {
        return
                "Name: " + this.guestName
                + "\nEmail: " + this.guestEmail
                + "\nPhone Number: " + this.guestPhoneNumber;
    }


}