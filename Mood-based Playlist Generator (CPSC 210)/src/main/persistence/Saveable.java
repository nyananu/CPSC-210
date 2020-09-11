package persistence;

// READ, SAVE AND WRITE were inspired by the TELLER APP

import java.io.PrintWriter;

public interface Saveable {
    // MODIFIES: printWriter
    // EFFECTS: writes the saveable to printWriter
    void save(PrintWriter printWriter);
}
