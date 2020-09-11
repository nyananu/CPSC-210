package model;

// Represents a song having a title and mood
public class Song {

    private String title;
    private Mood mood;

    // REQUIRES: Non empty String
    // EFFECTS: construct a Song with title and mood
    public Song(String songTitle, Mood songMood) {
        this.title = songTitle;
        this.mood = songMood;
    }

    // EFFECTS: get song title
    public String getTitle() {
        return title;
    }

    // EFFECTS: get song mood
    public Mood getMood() {
        return mood;
    }

    @Override
    public String toString() {
        return title + " " + mood + "\n";
    }
}
