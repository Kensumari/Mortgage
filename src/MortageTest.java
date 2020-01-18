import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MortageTest {

    @org.junit.jupiter.api.Test
    void powerOf() {
        assertEquals(8, Mortgage.powerOf(2F,3));
    }

    @org.junit.jupiter.api.Test
    void mortgageFormula() {
        Mortgage mortgage = new Mortgage("Juha", 1000F, 5F, 2);
        assertEquals(5142, mortgage.MortgageFormula(mortgage));
    }
}