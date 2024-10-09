package edu.kirkwood.java2eedemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction f1;
    private Fraction f2;

    @BeforeEach
    void setUp() {
        f1 = new Fraction();
        f2 = new Fraction(2, 3);
    }

    @Test
    void getNumerator() {
        assertEquals(1, f1.getNumerator());
        assertEquals(2, f2.getNumerator());
    }

    @Test
    void setNumerator() {
        f1.setNumerator(2);
        assertEquals(2, f1.getNumerator());
        assertEquals("2/1", f1.toString());
        f1.setNumerator(-2);
        assertEquals(-2, f1.getNumerator());
        assertEquals("-2/1", f1.toString());
    }

    @Test
    void getDenominator() {
        assertEquals(1, f1.getDenominator());
        assertEquals(3, f2.getDenominator());
    }

    @Test
    void setDenominator() {
        f1.setDenominator(2);
        assertEquals(2, f1.getDenominator());
        assertEquals("1/2", f1.toString());
        f1.setDenominator(-2);
        assertEquals(-2, f1.getDenominator());
        assertEquals("1/-2", f1.toString());
//        f1.setDenominator(0);
//        assertEquals(0, f1.getDenominator());
//        assertEquals("1/0", f1.toString());
        assertThrows(ArithmeticException.class, () -> f1.setDenominator(0));
    }

    @Test
    void testToString() {
        assertEquals("1/1", f1.toString());
        assertEquals("2/3", f2.toString());
    }

    @Test
    void gcd() {
        int result1 = Fraction.gcd(5, 7);
        int result2 = Fraction.gcd(-5, 7);
        int result3 = Fraction.gcd(5, -7);
        int result4 = Fraction.gcd(-5, -7);
        assertTrue(result1 == result2 && result2 == result3 && result3 == result4);
    }

    @Test
    void simplify() {
        f1.setNumerator(75);
        f1.setDenominator(45);
        f2 = f1.simplify();
        assertEquals("5/3", f2.toString());

        f1.setNumerator(2);
        f1.setDenominator(4);
        f2 = f1.simplify();
        assertEquals("1/2", f2.toString());

        f1.setNumerator(5);
        f1.setDenominator(7);
        f2 = f1.simplify();
        assertEquals("5/7", f2.toString());

        f1.setNumerator(-5);
        f1.setDenominator(7);
        f2 = f1.simplify();
        assertEquals("-5/7", f2.toString());

        f1.setNumerator(5);
        f1.setDenominator(-7);
        f2 = f1.simplify();
        assertEquals("-5/7", f2.toString());

        f1.setNumerator(-5);
        f1.setDenominator(-7);
        f2 = f1.simplify();
        assertEquals("5/7", f2.toString());

    }

    @Test
    void mixedNumber() {
        fail();
    }

    @Test
    void add() {
        fail();
    }
}