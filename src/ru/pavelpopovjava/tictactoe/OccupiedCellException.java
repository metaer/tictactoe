package ru.pavelpopovjava.tictactoe;

class OccupiedCellException extends InvalidUserTurnException {

    public String getMessage(){
        return "Ячейка уже занята. Укажите другую ячейку";
    }

}