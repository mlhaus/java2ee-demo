package edu.kirkwood.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorsTest {

    @Test
    void isANumber() {
    }

    @Test
    void isValidEmail() {
        assertTrue(Validators.isValidEmail("a@b.cd"));
        assertTrue(Validators.isValidEmail("abc@efg.hij"));
        assertFalse(Validators.isValidEmail(""));
        assertFalse(Validators.isValidEmail("a"));
        assertFalse(Validators.isValidEmail("a@"));
        assertFalse(Validators.isValidEmail("a@b"));
        assertFalse(Validators.isValidEmail("a@.c"));
        assertFalse(Validators.isValidEmail("a@b.c"));
    }
}