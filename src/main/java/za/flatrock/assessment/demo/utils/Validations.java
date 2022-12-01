package za.flatrock.assessment.demo.utils;

import java.util.regex.Pattern;

public class Validations {

    /*To validate if the cell phone number is South African*/
    public boolean validatePhoneNumber(String phoneNumber) {

        String str = "^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?";

        return Pattern.compile(str).matcher(phoneNumber).matches();
    }
}
