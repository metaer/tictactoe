package ru.pavelpopovjava.tictactoe;

class InvalidUserSymbolException extends InvalidUserTurnException {

    public String getMessage(){
        return "Поставить в ячейку можно либо знак \'" + Game.ZERO + "\', либо знак \"" + Game.CROSS + "\" ";
    }

}
