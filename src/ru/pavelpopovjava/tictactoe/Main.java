package ru.pavelpopovjava.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Создаем игру
        Game game = Game.getInstance();

        //Начинаем: Приветствуем и спрашиваем у юзера его имя
        game.start();

        game.play();

        //Заканчиваем: выводим имя победителя.
        game.finish();

    }
}
