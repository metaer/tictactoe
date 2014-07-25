package ru.pavelpopovjava.tictactoe;

import java.util.Scanner;

class ScannerWrapper {
    private static Scanner ourInstance = new Scanner(System.in);

    public static Scanner getInstance() {
        return ourInstance;
    }

    private ScannerWrapper() {
    }
}
