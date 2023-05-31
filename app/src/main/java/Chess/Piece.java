package Chess;

import android.util.Pair;
import java.util.ArrayList;

public abstract class Piece {

    Pair<Integer, Integer> position;
    boolean color;
    ArrayList<Pair<Integer, Integer>> movesList;

    private int picture;

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

    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Pair<Integer, Integer> kingPosition)
    {
        return null;
    }

    protected boolean isCheck(ArrayList<Piece> pieces, Pair<Integer, Integer> kingPosition)
    {
        for (Piece piece : pieces) {
            if (isAttacking(piece, kingPosition)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isAttacking(Piece piece, Pair<Integer, Integer> kingPosition) {
        return false;
    }

    protected boolean isValidSquare(int column, int row) {
        return column >= 0 && column < 8 && row >= 0 && row < 8;
    }

    protected boolean IsNotOccupied (int column, int row, ArrayList<Piece> white, ArrayList<Piece> black) {
        Pair<Integer, Integer> pair = new Pair<>(column, row);
        for(Piece piece : (color ? black : white))
            if(piece.getPosition().equals(pair))
                return false;
        return true;
    }
}

