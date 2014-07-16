package ru.pavelpopovjava.tictactoe;

class OccupiedCellException extends InvalidTurnException {

    public String getMessage(){
        return "Ячейка уже занята";
    }

}
