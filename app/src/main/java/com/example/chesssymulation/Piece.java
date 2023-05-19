package com.example.chesssymulation;

import java.util.ArrayList;

public abstract class Piece {

    private Square position;

    private boolean color;

    private ArrayList<Square> movesList;

    public Square getPosition() {
        return position;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public ArrayList<Square> getMovesList() {
        return movesList;
    }

    public void setMovesList(ArrayList<Square> movesList) {
        this.movesList = movesList;
    }

    public void possibleMoves() {

    }

    public boolean isMovable() {
        return false;
    }
}

