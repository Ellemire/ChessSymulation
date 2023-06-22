package Chess;

import android.util.Pair;
import java.util.ArrayList;

/**
 * Klasa abstrakcyjna "Bierka" (ang. Piece) po której dziedziczą klasy poszczególnych figur.
 */
@SuppressWarnings("unused")
public abstract class Piece {

    protected Pair<Integer, Integer> position;
    protected boolean color;
    protected ArrayList<Pair<Integer, Integer>> movesList;

    protected int picture;

    /** Konstruktor.
     * @param position pozycja bierki zapisana w formie pary obiektów typu Integer
     * @param color kolor bierki: true - biały, false - czarny
     */
    public Piece(Pair<Integer, Integer> position, boolean color) {
        this.position = position;
        this.color = color;
    }
    //gettery i settery

    /** Getter dla parametru color.
     * @return kolor bierki: true - biały, false - czarny
     */
    public boolean isColor() {
        return color;
    }

    /** Setter dla parametru color.
     * @param color kolor bierki: true - biały, false - czarny
     */
    public void setColor ( boolean color){
        this.color = color;
    }

    /** Getter dla parametru position.
     * @return pozycja zapisana w formie pary obiektów typu Integer
     */
    public Pair<Integer, Integer> getPosition () {
        return position;
    }

    /** Setter dla parametru position.
     * @param position pozycja zapisana w formie pary obiektów typu Integer
     */
    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }

    /** Getter dla parametru movesList.
     * @return lista ruchów
     */
    public ArrayList<Pair<Integer, Integer>> getMovesList() {
        return movesList;
    }

    /** Setter dla parametru movesList.
     * @param movesList lista ruchów
     */
    public void setMovesList(ArrayList<Pair<Integer, Integer>> movesList) {
        this.movesList = movesList;
    }

    /** Getter dla parametru picture.
     * @return numer odpowiadający obrazkowi danej figury
     */
    public int getPicture() {
        return picture;
    }

    /** Setter dla parametru picture.
     * @param picture numer odpowiadający obrazkowi danej figury
     */
    public void setPicture(int picture) {
        this.picture = picture;
    }

    /** Metoda sprawdzająca możliwe do wykonania ruchy dla danej bierki.
     * @param white lista białych bierek
     * @param black lista czarnych bierek
     * @param yourKing pozycja króla w kolorze danej figury
     * @return lista pól na które może ruszyć się bierka
     */
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing)
    {
        return null;
    }

    /** Metoda sprawdzająca czy istnieje dane pole.
     * @param column kolumna pola
     * @param row rząd pola
     * @return czy pole istnieje
     */
    protected boolean isValidSquare(int column, int row) {
        return column >= 0 && column < 8 && row >= 0 && row < 8;
    }

    /** Metoda sprawdzająca czy dane pole nie jest zajęte.
     * @param column kolumna pola
     * @param row rząd pola
     * @param white lista białych bierek
     * @param black lista czarnych bierek
     * @return czy pole jest dostępne
     */
    protected boolean isNotOccupied(int column, int row, ArrayList<Piece> white, ArrayList<Piece> black) {
        Pair<Integer, Integer> pair = new Pair<>(column, row);
        for(Piece piece : (color ? white : black))
            if(piece.getPosition().equals(pair))
                return false;
        return true;
    }
}

