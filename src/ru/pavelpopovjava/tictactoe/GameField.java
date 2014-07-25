package ru.pavelpopovjava.tictactoe;

class GameField {

    public static final int FIELDSIZE = 3; //Поле в кретсиках-ноликах (стандартный размер 3х3)

    /**
     * Массив колонок (массив массивов ячеек)
     */
    private char[][] field = new char[3][3];

    /**
     * Конструктор игрового поля
     */
    GameField(){

        setEmptyValuesInAllCells();

    }

    /**
     * Инициализация поля
     * Заполняет все ячейки поля пустыми значениями
     */
    private void setEmptyValuesInAllCells() {
        int x = 0; //Номер колонки (нумерация начинается с 1)
        int y; //Номер ряда (номер ячейки в колонке) (нумерация начинается с 1)

        for (char[] col : field){

            x++;
            y = 0;

            for (char val : col){

                y++;

                field[x-1][y-1] = Game.EMPTY;

            }
        }
    }

    /**
     * Устанавливает указанную ячейку в поле переданным значением
     * @param col
     * @param row
     * @param val
     */
    public void setCellValue(int col, int row, char val){

        field[col-1][row-1] = val;

    }

    /**
     * Возвращает значения указанной ячейки
     * @param col
     * @param row
     * @return
     */
    public char getCellValue(int col, int row){
        return field[col-1][row-1];
    }

    public boolean cellIsEmpty(int col, int row) {
        return field[col-1][row-1] == Game.EMPTY;
    }

    public boolean isDraw() {
        for (int i = 0; i < GameField.FIELDSIZE; i++) {
            for (int j = 0; j < GameField.FIELDSIZE; j++) {
                if (field[i][j] == Game.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWin(char symbol) {
        return WinChecker.check(symbol);
    }

    public void render() {
        for (int row = 1; row <= GameField.FIELDSIZE; row++) {
            for (int col = 1; col <= GameField.FIELDSIZE; col++) {
                System.out.print("|" + getCellValue(col, row));
                if (col == GameField.FIELDSIZE) {
                    System.out.println("|");
                }
            }
        }
    }
}
