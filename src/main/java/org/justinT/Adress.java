package org.justinT;

public class Adress {
    public enum Province {
        QC, ON, NS, NB, MB, BC, PE, SK, AB, NL, NT, YT, NU
    }
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;
}

/**
 * checks if a postal code is valid
 * @param postalCode the postal code to check
 * @return true if valid, false if not
 */
public static boolean isPostalCodeValid(String postalCode) {
    if (postalCode == null || postalCode.length() != 6) {
        return false;
    }
    for (int i = 0; i < 6; i++) {
        char ch = postalCode.charAt(i);

        if (i % 2 == 0) {
            if (!(Character.isLetter(ch))) {
                return false;
            }
        } else {
            if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
    }
    return true;
}

public Address(int streetNo, String street, String city, Province province, String postalCode) {

}