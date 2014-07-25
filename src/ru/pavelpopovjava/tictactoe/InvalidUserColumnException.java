package ru.pavelpopovjava.tictactoe;

class InvalidUserColumnException extends InvalidUserTurnException {

    public String getMessage(){
        return "Номер колонки может быть в пределах от 1 до 3 включительно";
    }

}
