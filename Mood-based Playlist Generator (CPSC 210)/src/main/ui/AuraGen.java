package ui;

import exception.InvalidSelectionException;

import model.Save;
import model.SongList;
import persistence.Reader;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class AuraGen extends JFrame {
    private static final String PLAYLIST_FILE = "./data/playlist.txt";
    private SongList plist;

    SongList songList = new SongList();
    Save save = new Save(songList);
    Scanner userInput = new Scanner(System.in);

    public AuraGen() throws InvalidSelectionException {
        greeting();
        moodChoice();
        furtherChoice();
    }

    // EFFECTS: initial menu
    private void greeting() {
        System.out.println("Welcome to AuraGen. In order to mirror how you feel, I will design a playlist for you."
                + "\n" + "What shall I call it?" + "\n" + "(Enter 1 - 10 letters)");
        String s;
        s = userInput.nextLine();

        loadPlaylist();

        while ((s.length() < 1) || (s.length() >= 10)) {
            System.out.println("Please enter between 1 - 10 letters \n");
            System.out.println("What shall I call the playlist? \n");

            s = userInput.nextLine();
        }
        System.out.println("Your playlist name is: " + s);
        songList.setSongListName(s);

    }


    // EFFECTS: choose mood
    public void moodChoice() {

        System.out.println("Let's continue. How are you feeling today?"
                + "\n" + "1 - Happy"
                + "\n" + "2 - Sad"
                + "\n" + "3 - Romantic");

        int i = userInput.nextInt();

        if (i == 1) {
            System.out.println("Here is your customized playlist! \n");
            System.out.println(songList.getSongListName().toUpperCase());
            songList.getHappy();
        } else if (i == 2) {
            System.out.println("Here is your customized playlist! \n");
            System.out.println(songList.getSongListName().toUpperCase());
            songList.getSad();
        } else if (i == 3) {
            System.out.println("Here is your customized playlist! \n");
            System.out.println(songList.getSongListName().toUpperCase());
            songList.getRomantic();
        } else {
            System.out.println("Invalid Menu Selection");
        }
    }


    // EFFECTS: ask about if user wants to add or delete a song, or quit
    public void furtherChoice() throws InvalidSelectionException {
        System.out.println("\n Do you wish to modify it further?"
                + "\n 1 - Add a song"
                + "\n 2 - No ");
        // if loop of adding deleting or quitting.
        int j = userInput.nextInt();
        if (j == 1) {
            userAdd();
        } else if (j == 2) {
            System.out.println("\n Thanks for using AuraGen, goodbye!");
        } else {
            System.out.println("\n Invalid Selection");
        }
    }

    //EFFECTS: takes user input and adds the song
    public String userAdd() throws InvalidSelectionException {
        userInput.nextLine();
        System.out.println("\n Enter the name of the song you want to add: ");
        String a = userInput.nextLine();
        System.out.println("What is the mood of the song?" + "\n 1 - Happy" + "\n 2 - Sad" + "\n 3 - Romantic");
        int m = userInput.nextInt();
        userInput.nextLine();
        System.out.println("\n Here is your updated playlist");
        System.out.println(songList.getSongListName().toUpperCase());
        if (m == 1) {
            songList.addHappy(a);
            songList.getHappy();
        } else if (m == 2) {
            songList.addSad(a);
            songList.getSad();
        } else if (m == 3) {
            songList.addRomantic(a);
            songList.getRomantic();
        }
        askSave();
        return plist.toString();
    }

    //EFFECTS: asks to save playlist
    public void askSave() {
        System.out.println("\nDo you wish to save this playlist?"
                + "\n1- Yes"
                + "\n2- No");
        int a = userInput.nextInt();

        if (a == 1) {
            save.savePlaylist();
            System.out.println("Your playlist has been saved.");
            System.out.println("Thanks for using AuraGen, goodbye.");
        } else if (a == 2) {
            System.out.println("Thanks for using AuraGen, goodbye.");
        } else {
            System.out.println("\n Invalid selection");
        }
    }

    //EFFECTS: loads playlist
    public void loadPlaylist() {
        try {
            List<SongList> playlist = Reader.readPlaylist(new File(PLAYLIST_FILE));
            plist = playlist.get(0);
        } catch (IOException e) {
            init();
        }

    }

    //EFFECTS: initializes a songList
    private void init() {
        plist = new SongList();
    }
}
