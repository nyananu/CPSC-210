
package persistence;

import model.SongList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// READ, SAVE AND WRITE were inspired by the TELLER APP
public class Reader {
    public static final String DELIMITER = "-";

    // EFFECTS: returns a list of songs parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<SongList> readPlaylist(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of songs parsed from list of strings
    // where each string contains data for one song
    private static List<SongList> parseContent(List<String> fileContent) {
        List<SongList> songs = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            songs.add(parsePlaylist(lineComponents));
        }
        return songs;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // EFFECTS: returns a SongList constructed from components
    private static SongList parsePlaylist(List<String> songs) {
        return new SongList();
    }
}

