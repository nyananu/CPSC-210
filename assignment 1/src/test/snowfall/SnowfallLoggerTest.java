package snowfall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the SnowfallLogger
class SnowfallLoggerTest {
    SnowfallLogger l1;
    SnowfallLogger l2;
    SnowfallLogger l3;

    @BeforeEach
    public void runBefore() {
        l1 = new SnowfallLogger();
        l2 = new SnowfallLogger();
        l3 = new SnowfallLogger();
    }

    @Test
    public void testConstructor() {
        assertEquals(0,l1.getNumSnowfallRecords());
    }

    @Test
    public void testAddSingleSnowfallRecord() {
        l1.addSnowfallRecord(5);
        assertEquals(5, l1.getAverageSnowfall());
        assertEquals(1,l1.getNumSnowfallRecords());
    }

    @Test
    public void testAddMultipleSnowfallRecords() {
        l1.addSnowfallRecord(5);
        l1.addSnowfallRecord(20);
        assertEquals(12.5, l1.getAverageSnowfall());
        assertEquals(2,l1.getNumSnowfallRecords());
        assertEquals(1,l1.getNumSnowDays());
    }

    @Test
    public void testNumSnowDays() {
        l1.addSnowfallRecord(10);
        l1.addSnowfallRecord(13);
        assertEquals(0,l1.getNumSnowDays());
        l2.addSnowfallRecord(20);
        assertEquals(1,l2.getNumSnowDays());
        l3.addSnowfallRecord(2);
        l3.addSnowfallRecord(100);
        assertEquals(1,l3.getNumSnowDays());
    }

    @Test
    public void testReset() {
        l1.reset();
        assertEquals(0,l1.amount);
        assertEquals(0,l1.sDay);
        assertEquals(0,l1.sRecord);
    }
}