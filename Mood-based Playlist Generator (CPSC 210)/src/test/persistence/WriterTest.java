package persistence;

// READ, SAVE AND WRITE were inspired by the TELLER APP

import model.SongList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class WriterTest {
    private static final String TEST_FILE = "./data/testAccounts.txt";
    private Writer testWriter;
    private SongList testList;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        testList = new SongList();
    }

    @Test
    void testWriteAccounts() {
        testWriter.write(testList);
        testWriter.close();
    }
}
