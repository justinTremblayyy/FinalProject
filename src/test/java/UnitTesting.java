import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.justinT.*;


public class UnitTesting {

// Address Class
    @Test
    @DisplayName(
            "Valid postal code: K2P1L4")
    void testValidPostalCode() {
        String postalCode = "K2P1L4";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid postal code: AB12CD")
    void testInvalidPostalCode() {
        String postalCode = "AB12CD";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);

    }



}
