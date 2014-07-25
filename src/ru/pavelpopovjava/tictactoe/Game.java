package ru.pavelpopovjava.tictactoe;

import java.util.Scanner;

public class Game {

    public static final char CROSS = 'x'; //Крестик
    public static final char ZERO = '0'; //Нолик
    public static final char EMPTY = '_'; //Незаполненное поле

    /**
     * Показывает чей сейчас ход: если true - ход игрока, если false - ход компа.
     * Первый ход по дефолту - игрока
     */
    private boolean userTurn = true;

    private static Game ourInstance = new Game();

    public GameField getGameField() {
        return gameField;
    }

    private GameField gameField;

    private String winner;

    private String userName;

    public static Game getInstance() {
        return ourInstance;
    }

    /**
     * Запрашивает имя игрока
     */
    private void whatIsYourName(){

        Scanner scanner = ScannerWrapper.getInstance();

        System.out.println("Как тебя зовут?");
        String userName = scanner.nextLine();

        try{
            Validator.validateUserName(userName);
        }
        catch (EmptyUserNameException e){
            System.out.println("Имя пользователя не может быть пустым");
            whatIsYourName(); //рекурсия. Спрашиваем до тех пор, пока юзер не введт нормальное имя (не пустую строку)
            return;
        }

        this.userName = userName;

    }

    /**
     * Приветствует и спрашивает имя.
     */
    public void start() {
        System.out.println("Привет! Это игра крестики-нолики!");
        whatIsYourName(); //Спрос имени вынесен в отдельный метод на случай, если юзер введет пустую строку, чтобы спросить его имя по новой, но без повторного приветсвия
        initializeGameField();
        gameField.render();
        System.out.println(userName + ", Вы ходите крестиками. Первый ход за Вами!");
    }

    private void initializeGameField() {
        gameField = new GameField();
    }

    /**
     * Ход реального игрока
     * @return
     */
    public void makeUserTurn(){

        Scanner scanner = ScannerWrapper.getInstance();

        int col = 0;
        int row = 0;

        boolean validationResult = true;

        try{
            col = inputColumn();
            row = inputRow();
            //Проверим, не занята ли ещё указанная ячейка
            Validator.validateOccupiedCell(col, row);
        }
        catch (InvalidUserTurnException e){
            System.out.println(e.getMessage());
            makeUserTurn(); //рекурсия
            return;
        }

        gameField.setCellValue(col, row, CROSS);
        System.out.println("\nТвой ход:");

    }

    private int inputRow() {
        Scanner scanner = ScannerWrapper.getInstance();
        int row;
        boolean validationResult;
        do {
            System.out.println("Введите номер ряда");
            row = Integer.valueOf(scanner.nextInt());
            validationResult = Validator.validateColumn(row);
            if (!validationResult) {
                System.out.println("Номер ряда может быть в пределах от 1 до 3 включительно");
            }

        } while (!validationResult);
        return row;
    }

    private int inputColumn() {
        Scanner scanner = ScannerWrapper.getInstance();
        int col;
        boolean validationResult;
        do {
            System.out.println("Введите номер колонки");
            col = Integer.valueOf(scanner.nextInt());
            validationResult = Validator.validateColumn(col);
            if (!validationResult) {
                System.out.println("Номер колонки может быть в пределах от 1 до 3 включительно");
            }

        } while (!validationResult);
        return col;
    }

    private void setWinner() {
        winner = userTurn ? userName : "Computer";
    }

    public void finish(){
        if (winner == null){
            System.out.println("Ничья!");
        } else {
            System.out.println("Победил " + winner + "!");
        }
    }

    public void play(){

        Scanner scanner = ScannerWrapper.getInstance();

        boolean turnResult;

        //Пока не определится победитель (или ничья), делаем ходы. Первым начинает (так уж и быть) юзер
        while (true){

            turnResult = makeTurn();

            gameField.render();

            userTurn = !userTurn;

            if (turnResult) {
                break;
            }
        }
    }

    private boolean makeTurn() {
        if (userTurn){
            System.out.println("\nСделай ход");
            makeUserTurn();
            return checkAfterTurn();
        }
        else{
            makeComputerTurn();
            return checkAfterTurn();
        }
    }

    private boolean checkAfterTurn() {

        char symbol = userTurn ? Game.CROSS : Game.ZERO;

        if (gameField.isWin(symbol)) {
            setWinner();
            return true;
        } else if (gameField.isDraw()) {
            return true;
        }

        return false;
    }

    /**
     * Ход игрока-компьютера
     */
    private void makeComputerTurn(){
        //TODO сделать умные ходы компьютера

        System.out.println("Ход компа:");

        //Пока что ставим нолик в первую же свободную ячейку

        int[] coords = findFreeCell();

        assert coords != null;

        gameField.setCellValue(coords[0], coords[1], Game.ZERO);

    }

    private int[] findFreeCell() {
        for (int row = 1; row <= GameField.FIELDSIZE; row++) {
            for (int col = 1; col <= GameField.FIELDSIZE; col++) {
                if (gameField.getCellValue(col, row) == Game.EMPTY) {
                    int[] arr = {col, row};
                    return arr;
                }
            }
        }

        return null;
    }

    private Game() {
    }
}
