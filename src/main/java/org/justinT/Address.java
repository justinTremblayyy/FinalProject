package org.justinT;

public class Address {
    public enum Province {
        QC, ON, NS, NB, MB, BC, PE, SK, AB, NL, NT, YT, NU
    }
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;



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


    /**
     * @param streetNo the street number
     * @param street the street name
     * @param city the city
     * @param province the province
     * @param postalCode the postal code
     */
    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode.toUpperCase();
        } else {
        this.streetNo = 0;
        this.street = null;
        this.city = null;
        this.province = null;
        this.postalCode = null;
        }
    }
}
