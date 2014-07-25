package ru.pavelpopovjava.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Валидатор
 */
class Validator {

    /**
     * Проверяет, чтобы координата колонки находилась в пределах от 1 до 3
     * @param col
     */
    public static boolean validateColumn(int col) {
        return minmax(1, GameField.FIELDSIZE, col);
    }

    /**
     * * Проверяет, чтобы координата ряда находилась в пределах от 1 до 3
     * @param row
     */
    public static boolean validateRow(int row) {
        return minmax(1, GameField.FIELDSIZE, row);
    }


    /**
     * Проверят, что введенный символ - либо кресте, либо нолик
     * @param symbol
     * @throws InvalidUserSymbolException
     */
    public static void validateSymbol(char symbol) throws InvalidUserSymbolException {

        List validСhars = new ArrayList(); //Массив из допустимых символов для ввода (крести и нолик)
        validСhars.add(Game.CROSS);
        validСhars.add(Game.ZERO);

        if (!validСhars.contains(symbol)){
            throw new InvalidUserSymbolException();
        }
    }

    /**
     * Проверяет, не занята ли эта ячейка
     * @param col
     * @param row
     * @throws OccupiedCellException
     */
    public static void validateOccupiedCell(int col, int row) throws OccupiedCellException {
        if (!Game.getInstance().getGameField().cellIsEmpty(col, row)) {
            throw new OccupiedCellException();
        }
    }

    /**
     * Проверяет, не пустое ли имя ввел юзер
     * @param userName
     * @throws EmptyUserNameException
     */
    public static void validateUserName(String userName) throws EmptyUserNameException{
        if (userName.equals("")){
            throw new EmptyUserNameException();
        }
    }

    /**
     * Проверяет, что переданное значение входит в указаннй диапазон. Если входит - возвращает true. Иначе false
     * @param min
     * @param max
     * @param val
     * @return
     */
    private static boolean minmax(int min, int max, int val){
        return !(val < min || val > max);
    }
}

