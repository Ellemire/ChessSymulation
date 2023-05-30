package Chess;

import android.util.Pair;
import java.util.ArrayList;

public class Piece {

    Pair<Integer, Integer> position;
    Pair<Integer, Integer> kingPosition;
    boolean color;
    ArrayList<Pair<Integer, Integer>> movesList;

    private int picture;

    static ArrayList<Pair<Integer,Integer>> PiecesListWhite = null;
    static ArrayList<Pair<Integer,Integer>> PiecesListBlack = null;

    //konstruktor
    public Piece(Pair<Integer, Integer> position, boolean color) {
        this.position = position;
        this.color = color;
    }

    //gettery i settery
    public boolean isColor() {
        return color;
    }
    public void setColor ( boolean color){
        this.color = color;
    }

    public Pair<Integer, Integer> getPosition () {
        return position;
    }
    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }

    public ArrayList<Pair<Integer, Integer>> getPiecesListWhite() {
        return PiecesListWhite;
    }
    public void setPiecesListWhite(ArrayList<Pair<Integer, Integer>> piecesListWhite) {
        PiecesListWhite = piecesListWhite;
    }

    public ArrayList<Pair<Integer, Integer>> getPiecesListBlack() {
        return PiecesListBlack;
    }
    public void setPiecesListBlack(ArrayList<Pair<Integer, Integer>> piecesListBlack) {
        PiecesListBlack = piecesListBlack;
    }

    public ArrayList<Pair<Integer, Integer>> getMovesList() {
        return movesList;
    }
    public void setMovesList(ArrayList<Pair<Integer, Integer>> movesList) {
        this.movesList = movesList;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    //inne
    public boolean isMovable () {
        return false;
    }

    public void Position() {
        Square square = new Square(10, 10); // tu jakoś przekażesz dane z szachownicy
        square.getPosition();
    }

    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves()
    {
        return null;
    }

}

