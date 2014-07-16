package ru.pavelpopovjava.tictactoe;

public class Validator {
    public static void validateColumn(int col) throws InvalidColumnException{
        if (false){
            throw new InvalidColumnException();
        }
    }

    public static void validateRow(int row) throws InvalidRowException{
        if (false){
            throw new InvalidRowException();
        }
    }

    public static void validateSymbol(int symbol) throws InvalidSymbolException{
        if (false){
            throw new InvalidSymbolException();
        }
    }

    public static void validateOccupiedCell(int col, int row) throws OccupiedCellException{
        if (false){
            throw new OccupiedCellException();
        }
    }

    public static void validateUserName(String userName) throws EmptyUserNameException{
        if (userName.equals("")){
            throw new EmptyUserNameException();
        }
    }
}

