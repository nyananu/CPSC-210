package ca.ubc.cpsc210.colour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ColourTest {
    Colour c1;
    Colour c2;
    Colour c3;


    @BeforeEach
    void runBefore() {
        c1 = new Colour(0,0,0  );
        c2 = new Colour(0,255,0);
        c3 = new Colour(255,255,255);
    }

    @Test
    void testIsGreyScale() {
    assertTrue(c3.isGreyScale());
    assertFalse(c2.isGreyScale());
    assertTrue(c1.isGreyScale());
    }

    @Test
    void testToHex() {
        assertEquals(Integer.toHexString((0 * 256 + 0) * 256 + 0), c1.toHex());
        assertEquals(Integer.toHexString((0 * 256 + 255) * 256 + 0), c2.toHex());
        assertEquals(Integer.toHexString((255 * 256 + 255) * 256 + 255), c3.toHex());
    }
}