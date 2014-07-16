package ru.pavelpopovjava.tictactoe;

import java.util.Scanner;

class Game {
    private static Game ourInstance = new Game();

    //TODO сделать свойство gameField

    private static String winner = "";

    private static String userName;

    public static Game getInstance() {
        return ourInstance;
    }

    private void whatIsYourName(){

        Scanner scanner = ScannerWrapper.getInstance();

        System.out.println("Как тебя зовут?");
        String userName = scanner.nextLine();

        try{
            Validator.validateUserName(userName);
        }
        catch (EmptyUserNameException e){
            System.out.println("Имя пользователя не может быть пустым");
            whatIsYourName();
        }

        this.userName = userName;

    }

    /**
     * Записывает имя пользователя
     */
    public void start() {
        System.out.println("Привет! Это игра крестики-нолики!");
        whatIsYourName();
    }

    /**
     * Ход реального игрока
     * Возвращает true, если определился победитель, false - если не определился победитель
     * @return
     */
    public boolean makeUserTurn(){

        Scanner scanner = ScannerWrapper.getInstance();

        try{
            System.out.println("Введите номер колонки");
            int col = Integer.valueOf(scanner.nextInt());
            Validator.validateColumn(col);

            System.out.println("Введите номер ряда");
            int row = Integer.valueOf(scanner.nextInt());
            Validator.validateRow(row);

            System.out.println("Введите знак (крестик или нолик)");
            char sign = scanner.nextLine().toCharArray()[0];
            Validator.validateSymbol(sign);

            //Проверим, не занята ли ещё указанная ячейка
            Validator.validateOccupiedCell(col, row);
        }
        catch (InvalidTurnException e){
            System.out.println(e.getMessage());
            makeUserTurn();
        }

        return false;
    }

    public void finish(){
        System.out.println(winner);
    }

    public void play(){

        Scanner scanner = ScannerWrapper.getInstance();

        //Пока не определится победитель, делаем ходы. Первым начинает (так уж и быть) юзер
        while (true){

            System.out.println("Сделай ход");

            boolean turnResult = makeUserTurn();

            if (turnResult) {
                break;
            }
        }
    }

    /**
     * Ход игрока-компьютера
     * Возвращает true, если определился победитель, false - если не определился победитель
     */
    private boolean makeComputerTurn(){
        return false;
    }

    private Game() {
    }
}
