package model;

import persistence.Writer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Save {
    private static final String PLAYLIST_FILE = "./data/playlist.txt";
    SongList songList;

    public Save(SongList s) {
        this.songList = s;
    }

    // EFFECTS: Saves the Playlist into a txt file
    public void savePlaylist() {
        try {
            Writer writer = new Writer(new File(PLAYLIST_FILE));
            writer.write(songList);
            writer.close();

            // below for loop has been taken from
            // (https://stackoverflow.com/questions/2788080/java-how-to-read-a-text-file)

            for (String line : Files.readAllLines(Paths.get("./data/playlist.txt"))) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save playlist to " + PLAYLIST_FILE);
        } catch (UnsupportedEncodingException e) {
            System.out.println("This is due to a programming error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
