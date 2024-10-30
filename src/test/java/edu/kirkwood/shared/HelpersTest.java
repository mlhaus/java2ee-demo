package edu.kirkwood.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpersTest {

    @Test
    void round() {
        assertEquals("1", Helpers.round(1.1, 0));
        assertEquals("1", Helpers.round(1.49, 0));
        assertEquals("2", Helpers.round(1.5, 0));
        assertEquals("2", Helpers.round(1.9, 0));

        assertEquals("1.4", Helpers.round(1.41, 1));
        assertEquals("1.5", Helpers.round(1.49, 1));
        assertEquals("1.4", Helpers.round(1.449, 1));
        assertEquals("1.5", Helpers.round(1.451, 1));

        assertEquals("1.6", Helpers.round(1.55, 1));
        assertEquals("2.6", Helpers.round(2.55, 1));

    }
}