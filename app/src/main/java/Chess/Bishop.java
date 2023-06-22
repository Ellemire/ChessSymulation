package Chess;

import android.util.Pair;

import java.util.ArrayList;

/**
 * Klasa "Goniec" dziedzicząca po klasie "Bierka" (ang. Piece).
 * Goniec porusza się po planszy po skosach. Jest odpowiednio białopolowy ub czarnopolowy w zależności od swojego ustawienia początkowego.
 */
public class Bishop extends Piece {

    /** Konstruktor obiektu typu "Goniec".
     * @param position pozycja bierki zapisana w formie pary obiektów typu Integer
     * @param color kolor bierki: true - biały, false - czarny
     */
    //konstruktor
    public Bishop(Pair<Integer, Integer> position, boolean color) {
        super(position, color);
    }

    /** Metoda zwracająca możliwe ruchy do wykonania dla gońca.
     * Goniec porusza się po skosach.
     * @param white    lista białych bierek
     * @param black    lista czarnych bierek
     * @param yourKing pozycja króla w kolorze danej figury
     * @return lista dostępnych ruchów
     */
    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        // Ruchy na prawo-górę
        for(int column = position.first + 1; column < 8; column++)
        {
            int row = position.second + column - position.first;
            if (!isNotOccupied(column, row, white, black) || row > 7)
                break;
            if (isNotOccupied(column, row, white, black)) {
                possibleMoves.add(new Pair<>(column, row));
                if(!isNotOccupied(column, row, black, white))
                    break;
            }
        }

        // Ruchy na lewo-górę
        for(int column = position.first - 1; column >= 0; column--)
        {
            int row = position.second + position.first - column;
            if (!isNotOccupied(column, row, white, black) || row > 7)
                break;
            if (isNotOccupied(column, row, white, black)) {
                possibleMoves.add(new Pair<>(column, row));
                if(!isNotOccupied(column, row, black, white))
                    break;
            }
        }

        // Ruchy na prawo-dół
        for(int column = position.first + 1; column < 8; column++)
        {
            int row = position.second - (column - position.first);
            if (!isNotOccupied(column, row, white, black) || row < 0)
                break;
            if (isNotOccupied(column, row, white, black)) {
                possibleMoves.add(new Pair<>(column, row));
                if(!isNotOccupied(column, row, black, white))
                    break;
            }
        }

        // Ruchy na lewo-dół
        for(int column = position.first - 1; column >= 0; column--)
        {
            int row = position.second - (position.first - column);
            if (!isNotOccupied(column, row, white, black) || row < 0)
                break;
            if (isNotOccupied(column, row, white, black)) {
                possibleMoves.add(new Pair<>(column, row));
                if(!isNotOccupied(column, row, black, white))
                    break;
            }
        }

        movesList = possibleMoves;
        return possibleMoves;
    }
}