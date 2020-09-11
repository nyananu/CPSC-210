package ui;

import model.SongList;

import javax.swing.*;

import java.io.*;
import java.util.Scanner;


public class GUI extends JFrame {
    private static final String PLAYLIST_FILE = "./data/playlist.txt";
    private JPanel auraPanel;
    private JLabel greetingMsg; //
    private JTextField playlistName;
    private JLabel choiceMsg;  //
    private JRadioButton happyButton;
    private JRadioButton sadButton;
    private JRadioButton romanticButton;
    private JTextArea textArea;
    private JButton quit;
    private JLabel addSong;  //
    private JTextField songName;
    private JButton savePlaylist;
    private JButton generatePlaylist;
    private JLabel savedPlaylists; //
    private JButton loadPlaylist;
    private JTextArea loadArea;
    SongList songList;
    String text = textArea.getText();


    public GUI(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(auraPanel);
        this.pack();

        songList = new SongList();

        setPlaylistNameFromUser();

        groupButton();

        generateSelectedPlaylist();

        addUserSong();

        saveUserPlaylist();


        loadPlaylist.addActionListener(e -> {
            try {
                readFile();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            loadArea.append("\n" + PLAYLIST_FILE);
        });

        quit.addActionListener(e -> System.exit(0));
    }

    //EFFECTS: groups the radio buttons together so that only one is selected
    public void groupButton() {
        ButtonGroup group1 = new ButtonGroup();
        group1.add(happyButton);
        group1.add(sadButton);
        group1.add(romanticButton);

    }
    //EFFECTS: sets playlist name from user

    public void setPlaylistNameFromUser() {
        playlistName.addActionListener(e -> {
            // this will set the playlist name from the user
            String name = playlistName.getText();
            textArea.setText(name.toUpperCase() + "\n");
        });
    }

    //EFFECTS: Displays list based on user mood choice
    public void userMoodChoice() {
        if (happyButton.isSelected()) {
            textArea.append(songList.getHappy().toString() + "\n");
        } else if (sadButton.isSelected()) {
            textArea.append(songList.getSad().toString() + "\n");
        } else if (romanticButton.isSelected()) {
            textArea.append(songList.getRomantic().toString() + "\n");
        }
    }

    //EFFECTS: generates a playlist in the text box with sound played
    public void generateSelectedPlaylist() {
        generatePlaylist.addActionListener(e -> {
            userMoodChoice();
            java.awt.Toolkit.getDefaultToolkit().beep();
        });
    }

    //EFFECTS: allows user to add a song to the playlist
    public void addUserSong() {
        songName.addActionListener(e -> {
            String userSong = songName.getText();
            textArea.append(userSong);
        });
    }

    //EFFECTS: saves the generated playlist into txt file
    public void saveUserPlaylist() {
        savePlaylist.addActionListener(e -> {
            // taken from
            // https://stackoverflow.com/questions/32143640/how-to-save-jtextfield-value-to-a-txt-file-as-a-log
            String content = textArea.getText();    //step1: get the content of the textfield

            try {

                File file = new File("./data/playlist.txt");

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);    //step2: write it
                bw.close();

                textArea.append("\n *********** YOUR PLAYLIST IS SAVED! ***********\n");

            } catch (IOException g) {
                g.printStackTrace();
            }
        });
    }

    //EFFECTS: loads the saved playlist into the side text box
    private void readFile() throws FileNotFoundException {
        File file = new File("./data/playlist.txt");
        String fileContent = new Scanner(file).useDelimiter("\\Z").next();
        loadArea.setText(fileContent);
    }


}

