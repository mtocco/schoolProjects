/*
 * Course: CSC 335
 * Professor: Sean Harrington
 * Student Team: Pedro Alvelo, Kevin Scaringi, Michael Tocco
 *  
 */
package tictactoe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailChecker {

    /**
     * Takes email form and checks for valid form using Regex 
     */
    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

}
