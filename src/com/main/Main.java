package com.main;

import ru.pavelpopovjava.tictactoe.Game;

/**
 * Главный класс
 */
public class Main {

    /**
     * Точка входа
     * @param args
     */
    public static void main(String[] args) {

        //Создаем игру
        Game game = Game.getInstance();

        //Начинаем: Приветствуем и спрашиваем у юзера его имя
        game.start();

        game.play();

        //Заканчиваем: выводим имя победителя (либо сообщение о ничье)
        game.finish();

    }
}
