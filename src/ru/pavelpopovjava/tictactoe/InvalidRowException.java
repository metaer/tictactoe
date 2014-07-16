package ru.pavelpopovjava.tictactoe;

class InvalidRowException extends InvalidTurnException {

    public String getMessage(){
        return "Номер ряда может быть в пределах от 1 до 3 включительно";
    }

}
