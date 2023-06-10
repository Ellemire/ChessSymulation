package Chess;

import android.util.Pair;
import java.util.ArrayList;

public abstract class Piece {

    protected Pair<Integer, Integer> position;
    protected boolean color;
    protected ArrayList<Pair<Integer, Integer>> movesList;

    protected int picture;

    /** konstruktor
     * @param position pozycja bierki
     * @param color kolor bierki
     */
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

//    public boolean canStand(Pair<Integer,Integer> square){
//        if (calculatePossibleMoves())
//    }

    /** Metoda sprawdzająca możliwe do wykonania ruchy dla danej bierki
     * @param white lista białych bierek
     * @param black lista czarnych bierek
     * @param yourKing pozycja króla w kolorze danej figury
     * @return lista pól na które może ruszyć się bierka
     */
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing)
    {
        return null;
    }

    protected boolean isCheck(ArrayList<Piece> pieces, Pair<Integer, Integer> kingPosition)
    {
        for (Piece piece : pieces) {
            if(piece.color != color)
                if (isAttacking(piece, kingPosition))
                    return true;
        }
        return false;
    }

    protected boolean isAttacking(Piece piece, Pair<Integer, Integer> kingPosition) {
        return false;
    }

    /** metoda sprawdzająca czy istnieje dane pole
     * @param column kolumna
     * @param row rząd
     * @return czy pole istnieje
     */
    protected boolean isValidSquare(int column, int row) {
        return column >= 0 && column < 8 && row >= 0 && row < 8;
    }

    /** metoda sprawdzająca czy dane pole nie jest zajęte
     * @param column kolumna
     * @param row rząd
     * @param white lista białych bierek
     * @param black lista czarnych bierek
     * @return czy pole jest dostępne
     */
    protected boolean IsNotOccupied (int column, int row, ArrayList<Piece> white, ArrayList<Piece> black) {
        Pair<Integer, Integer> pair = new Pair<>(column, row);
        for(Piece piece : (color ? white : black))
            if(piece.getPosition().equals(pair))
                return false;
        return true;
    }
}

