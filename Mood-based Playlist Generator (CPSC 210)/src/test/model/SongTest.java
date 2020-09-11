package model;

import exception.InvalidSelectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    SongList list1;


    @BeforeEach
    void runBefore() {
        list1 = new SongList();
    }

    @Test
    public void testSize() {
        assertEquals(18, list1.size());
    }

    @Test
    public void testGetHappy() {
        assertEquals(list1.getHappy(), list1.getHappy());
        assertEquals(6, list1.getHappy().size());
    }

    @Test
    public void testGetSad() {
        assertEquals(list1.getSad(), list1.getSad());
        assertEquals(6, list1.getSad().size());
    }

    @Test
    public void testGetRomantic() {
        assertEquals(list1.getRomantic(), list1.getRomantic());
        assertEquals(6, list1.getRomantic().size());
    }

    @Test
    public void testAddHappy() {
        try {
            list1.addHappy("happy");
        } catch (InvalidSelectionException e) {
            System.out.println("Invalid");
        }
        assertEquals(19, list1.size());
        assertEquals(list1.getHappy(), list1.getHappy());
    }

    @Test
    public void testAddSad() {
        try {
            list1.addSad("sad");
        } catch (InvalidSelectionException e) {
            System.out.println("Invalid");
        }
        assertEquals(19, list1.size());
        assertEquals(list1.getSad(), list1.getSad());
    }

    @Test
    public void testAddRomantic() {
        try {
            list1.addRomantic("romantic");
        } catch (InvalidSelectionException e) {
            System.out.println("Invalid");
        }
        assertEquals(19, list1.size());
        assertEquals(list1.getRomantic(), list1.getRomantic());
    }

    @Test
    public void testInvalidSongName() {
        try {
            list1.addHappy("");
        } catch (InvalidSelectionException e) {
            System.out.println("Invalid");
        }

    }

    @Test
    public void testSongGettersSetters() {
        Song s1 = new Song("test song", Mood.HAPPY);

        assertEquals("test song", s1.getTitle());
        assertEquals(Mood.HAPPY, s1.getMood());
    }

    @Test
    public void testPlaylistName() {
        list1.setSongListName("test list");
        assertEquals("test list", list1.getSongListName());
    }


}
