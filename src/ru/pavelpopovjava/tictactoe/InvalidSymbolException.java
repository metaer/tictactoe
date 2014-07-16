package ru.pavelpopovjava.tictactoe;

class InvalidSymbolException extends InvalidTurnException {

    public String getMessage(){
        return "Поставить в ячейку можно либо знак \"0\", либо знак \"x\" ";
    }

}
