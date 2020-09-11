package ui;

import exception.InvalidSelectionException;

public class Main {
    public static void main(String[] args) {
        try {
            new AuraGen();
        } catch (InvalidSelectionException e) {
            System.out.println("Invalid Selection");
        }
    }
}



