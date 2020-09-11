Please grade for Phase 3 and Phase 4

# AuraGen

## Mood-based music playlist generator

*Wouldn't it be nice if you could listen to music that mirrors the feeling you have at that moment?* 
*Wouldn't you love it if you could have a perfectly curated playlist for every occasion?*

**AuraGen** is an application designed to do just that! It is for everyone who wants to spend less time 
browsing and more time listening to a unique mood-based curated playlist!

*How it works*:
 select your current mood from the range of options given and get your curated playlist!

It's THAT simple!

## User Stories
- As a user, I want to be able to name my playlist.
- As a user, I want to be able to select from the given moods.
- As a user, I want to be able to view my generated playlist.
- As a user, I want to add a song to the playlist.
- As a user, I want to save my playlist.
- As a user, I want to view my saved playlist.

## Instructions for Grader
** I have developed the GUI using a GUI form **

- You can run the program from AuraGenGui.
- You can type your chosen playlist name in the text field and press ENTER.
- You can then choose from the given 3 mood buttons.
- When you click "Here is your Playlist!" you will hear my audio component which is a beep.
- You can type a name of the song you want to add in the text box and press ENTER to see it show up on the screen.
- You can save the playlist in a txt file using the Save button.
- You can load the path of the txt file using the Load button.
- You can exit the window using the Quit button.


## Phase 4: Task 2

I have chosen the first option which is "Test and design a class that is robust. You must have at least one method that
throws a checked exception. You must have one test for the case where the exception is expected and another where the 
exception is not expected."

In my SongList Class within the Model Package, there are 3 methods which throw a checked exception. They are:
- addHappy(String a);
- addSad(String a);
- addRomantic(String a);

The tests based on this Class and specifically this task are in test/model/SongTest and are named as follows:
- testAddHappy()
- testAddSad()
- testAddRomantic();
- testInvalidSongName();


## Phase 4: Task 3
 Problem 1: To improve Cohesion and Coupling I noticed that my SongList class had a method called savePlaylist() which
 wasn't in line with what the class was related to. Hence I made another class in Model called Save and let it handle 
 the saving aspect of my program.
 
 Problem 2: To improved Cohesion and Coupling I noticed that it was extremely redundant to have to pass the Song moods 
 as Strings, hence I made an Enumeration which contains the 3 moods, and used it throughout the program.