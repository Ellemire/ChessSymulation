package Chess;

import android.util.Pair;

import java.util.ArrayList;

/**
 * Klasa "Hetman" dziedzicząca po klasie "Bierka" (ang. Piece)
 */
public class Queen extends Piece {

    //konstruktor
    /** Konstruktor obiektu typu "Hetman".
     * @param position pozycja bierki zapisana w formie pary obiektów typu Integer
     * @param color kolor bierki: true - biały, false - czarny
     */
    public Queen(Pair<Integer, Integer> position, boolean color) {
        super(position, color);
    }

    /** Metoda zwracająca możliwe ruchy do wykonania dla hetmana.
     * Hetman porusza się na skosy albo po prostych.
     * @param white    lista białych bierek
     * @param black    lista czarnych bierek
     * @param yourKing pozycja króla w kolorze danej figury
     * @return lista dostępnych ruchów
     */
    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();
        // Ruchy w pionie
        for (int row = position.second + 1; row < 8; row++) {
            if (!isNotOccupied(position.first, row, white, black))
                break;
            possibleMoves.add(new Pair<>(position.first, row));
            if(!isNotOccupied(position.first, row, black, white))
                break;
        }
        for (int row = position.second - 1; row >= 0; row--) {
            if (!isNotOccupied(position.first, row, white, black))
                break;
            possibleMoves.add(new Pair<>(position.first, row));
            if(!isNotOccupied(position.first, row, black, white))
                break;
        }

        // Ruchy w poziomie
        for (int column = position.first + 1; column < 8; column++) {
            if(!isNotOccupied(column, position.second, white, black))
                break;
            if (column != position.first) {
                possibleMoves.add(new Pair<>(column, position.second));
                if(!isNotOccupied(column, position.second, black, white))
                    break;
            }
        }
        for (int column = position.first - 1; column >= 0; column--) {
            if(!isNotOccupied(column, position.second, white, black))
                break;
            if (column != position.first) {
                possibleMoves.add(new Pair<>(column, position.second));
                if(!isNotOccupied(column, position.second, black, white))
                    break;
            }
        }

        // Ruchy na skosach

        // Ruchy na prawo-górę
        for(int column = position.first + 1; column < 8; column++)
        {
            int row = position.second + column - position.first;
            if (!isNotOccupied(column, row, white, black) || row > 7)
                break;
            possibleMoves.add(new Pair<>(column, row));
            if(!isNotOccupied(column, row, black, white))
                break;
        }

        // Ruchy na lewo-górę
        for(int column = position.first - 1; column >= 0; column--)
        {
            int row = position.second + position.first - column;
            if (!isNotOccupied(column, row, white, black) || row > 7)
                break;
            possibleMoves.add(new Pair<>(column, row));
            if(!isNotOccupied(column, row, black, white))
                break;
        }

        // Ruchy na prawo-dół
        for(int column = position.first + 1; column < 8; column++)
        {
            int row = position.second - (column - position.first);
            if (!isNotOccupied(column, row, white, black) || row < 0)
                break;
            possibleMoves.add(new Pair<>(column, row));
            if(!isNotOccupied(column, row, black, white))
                break;
        }

        // Ruchy na lewo-dół
        for(int column = position.first - 1; column >= 0; column--)
        {
            int row = position.second - (position.first - column);
            if (!isNotOccupied(column, row, white, black) || row < 0)
                break;
            possibleMoves.add(new Pair<>(column, row));
            if(!isNotOccupied(column, row, black, white))
                break;
        }

        movesList = possibleMoves;
        return possibleMoves;
    }
}