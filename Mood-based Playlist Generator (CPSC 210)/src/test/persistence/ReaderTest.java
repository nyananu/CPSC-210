package persistence;

// READ, SAVE AND WRITE were inspired by the TELLER APP

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ReaderTest {
    @Test
    void testIOException() {
        try {
            Reader.readPlaylist(new File("./path/does/not/exist/testPlaylist.txt"));
        } catch (IOException e) {
            // expected
        }
    }


}
