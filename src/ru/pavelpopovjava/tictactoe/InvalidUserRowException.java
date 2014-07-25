package ru.pavelpopovjava.tictactoe;

class InvalidUserRowException extends InvalidUserTurnException {

    public String getMessage(){
        return "Номер ряда может быть в пределах от 1 до 3 включительно";
    }

}
