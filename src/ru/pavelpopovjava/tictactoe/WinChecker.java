package ru.pavelpopovjava.tictactoe;

class WinChecker {

    private static GameField gameField = Game.getInstance().getGameField();

    public static boolean check(char symbol){
        if (checkCols(symbol) || checkRows(symbol) || checkDiagonals(symbol)) {
            return true;
        }
        return false;
    }

    private static boolean checkCols(char symbol) {
        return checkLines(symbol, "cols");
    }

    private static boolean checkRows(char symbol) {
        return checkLines(symbol, "rows");
    }

    private static boolean checkDiagonals(char symbol) {
        if (gameField.getCellValue(1, 1) == symbol
                && gameField.getCellValue(2, 2) == symbol
                && gameField.getCellValue(3, 3) == symbol) {
            return true;
        }

        if (gameField.getCellValue(3, 1) == symbol
                && gameField.getCellValue(2, 2) == symbol
                && gameField.getCellValue(1, 3) == symbol) {
            return true;
        }

        return false;
    }


    /**
     * Проверяет линии (либо ряды, либо колонки) на победу
     * @param symbol
     * @param type - если rows - Ряды, если cols - колонки
     * @return
     */
    private static boolean checkLines(char symbol, String type) {
        outer: for (int row = 0; row < GameField.FIELDSIZE; row++) {

                    for (int col = 0; col < GameField.FIELDSIZE; col++) {
                        char cellValue = type == "rows" ? gameField.getCellValue(col+1, row+1) : gameField.getCellValue(row+1, col+1);
                        if (cellValue != symbol) {
                            continue outer;
                        }
                    }

                    return true;
        }

        return false;
    }


}
