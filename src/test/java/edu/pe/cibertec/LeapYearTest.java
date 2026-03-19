package edu.pe.cibertec;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeapYear - Unit testing")
public class LeapYearTest {

    private LeapYear leapYear;

    @BeforeEach
    void setUp(){
        leapYear = new LeapYear();
    }

    @Test
    @DisplayName("Divisible by 4")
    void giveYearDivisibleBy4_whenIsLeapYear_thenTrue(){
        assertTrue(leapYear.isLeapYear(2024));
    }

    @Test
    @DisplayName("Divisible by 400")
    void giveYearDivisibleBy400_whenIsLeapYear_thenTrue(){
        assertTrue(leapYear.isLeapYear(2000));
    }

    @Test
    @DisplayName("Not Divisible by 4")
    void givenYearNotDivisibleBy4_whenIsLeapYear_thenFalse(){
        assertFalse(leapYear.isLeapYear(2025));
    }

    @Test
    @DisplayName("Negative year throws exception")
    void givenNegativeYear_whenIsLeapYear_thenThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> leapYear.isLeapYear(-20));
    }

}
