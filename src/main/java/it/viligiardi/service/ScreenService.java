package it.viligiardi.service;

public class ScreenService {
    // attributes
    // methods and constructions
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
