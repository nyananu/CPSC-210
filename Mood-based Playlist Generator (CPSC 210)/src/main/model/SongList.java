package model;

import exception.InvalidSelectionException;

import persistence.Reader;
import persistence.Saveable;

import java.io.*;
import java.util.ArrayList;

public class SongList implements Saveable {

    ArrayList<Song> songList;
    private String songListName;


    // Constructor
    public SongList() {
        // creates a songList arrayList

        songList = new ArrayList<>();


        songList.add(new Song("Walking on Sunshine", Mood.HAPPY));
        songList.add(new Song("Uptown Funk", Mood.HAPPY));
        songList.add(new Song("Mic Drop", Mood.HAPPY));
        songList.add(new Song("I Gotta Feeling", Mood.HAPPY));
        songList.add(new Song("Girls Just Want to Have Fun", Mood.HAPPY));
        songList.add(new Song("Apanman", Mood.HAPPY));

        songList.add(new Song("The Scientist", Mood.SAD));
        songList.add(new Song("Heartbreak Warfare", Mood.SAD));
        songList.add(new Song("Call Out My Name", Mood.SAD));
        songList.add(new Song("Fix You", Mood.SAD));
        songList.add(new Song("Run", Mood.SAD));
        songList.add(new Song("Louder than Bombs", Mood.SAD));

        songList.add(new Song("All Of Me", Mood.ROMANTIC));
        songList.add(new Song("D.N.A", Mood.ROMANTIC));
        songList.add(new Song("Thinking Out Loud", Mood.ROMANTIC));
        songList.add(new Song("We Found Love", Mood.ROMANTIC));
        songList.add(new Song("Crazy In Love", Mood.ROMANTIC));
        songList.add(new Song("Perfect", Mood.ROMANTIC));
    }

    //EFFECTS: Returns the size of the list
    public int size() {
        int i;
        i = songList.size();
        return i;
    }

    public String getSongListName() {
        return songListName;
    }

    public void setSongListName(String s) {

        this.songListName = s;
    }

    //EFFECTS: returns a list of happy songs
    public ArrayList<String> getHappy() {
        ArrayList<String> happySongs = new ArrayList<>();
        for (Song s : songList) {
            if (s.getMood().equals(Mood.HAPPY)) {
                happySongs.add(s.getTitle());
                System.out.println("\n" + s.getTitle());
            }
        }
        return happySongs;
    }

    //REQUIRES: Non empty String
    //EFFECTS: adds a song to the list
    public void addHappy(String a) throws InvalidSelectionException {
        if (a.equals("")) {
            throw new InvalidSelectionException();
        } else {
            songList.add(new Song(a, Mood.HAPPY));
        }
    }

    //EFFECTS: returns a list of sad songs
    public ArrayList<String> getSad() {
        ArrayList<String> sadSongs = new ArrayList<>();
        for (Song s : songList) {
            if (s.getMood().equals(Mood.SAD)) {
                sadSongs.add(s.getTitle());
                System.out.println("\n" + s.getTitle());
            }
        }
        return sadSongs;
    }

    //REQUIRES: Non empty String
    //EFFECTS: adds a song to the list
    public void addSad(String a) throws InvalidSelectionException {
        if (a.equals("")) {
            throw new InvalidSelectionException();
        } else {
            songList.add(new Song(a, Mood.SAD));
        }
    }

    //EFFECTS: returns a list of romantic songs
    public ArrayList<String> getRomantic() {
        ArrayList<String> romanticSongs = new ArrayList<>();
        for (Song s : songList) {
            if (s.getMood().equals(Mood.ROMANTIC)) {
                romanticSongs.add(s.getTitle());
                System.out.println("\n" + s.getTitle());
            }
        }
        return romanticSongs;
    }


    //REQUIRES: Non empty String
    //EFFECTS: adds a song to the list
    public void addRomantic(String a) throws InvalidSelectionException {
        if (a.equals("")) {
            throw new InvalidSelectionException();
        } else {
            songList.add(new Song(a, Mood.ROMANTIC));
        }
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(Reader.DELIMITER);
        printWriter.print(songListName);
        printWriter.print(Reader.DELIMITER);
        printWriter.println(songList);
    }

}
