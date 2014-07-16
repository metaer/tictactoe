package ru.pavelpopovjava.tictactoe;

class InvalidColumnException extends InvalidTurnException {

    public String getMessage(){
        return "Номер колонки может быть в пределах от 1 до 3 включительно";
    }

}
