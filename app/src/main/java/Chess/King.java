package Chess;

import android.util.Pair;

import java.util.ArrayList;

/**
 * Klasa "Król" dziedzicząca po klasie "Bierka" (ang. Piece).
 */
public class King extends Piece {

    private final int[][] MOVES = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    /** Konstruktor obiektu typu "Król".
     * @param position pozycja bierki zapisana w formie pary obiektów typu Integer
     * @param color kolor bierki: true - biały, false - czarny
     */
    //konstruktor
    public King(Pair<Integer, Integer> position, boolean color) {
        super(position, color);
        this.position = position;
    }

    /** Metoda zliczająca dotępne do wykonania ruchy.
     * Król porusza się o jedno pole w każdym kierunku. Nie może stanąć obok króla przeciwnego koloru.
     * @param white    lista białych bierek
     * @param black    lista czarnych bierek
     * @param yourKing pozycja króla w kolorze danej figury
     * @return lista dostępnych ruchów dla bierki
     */
    //sprawdza możliwe ruchy dla króla
    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        for (int[] move : MOVES) {
            int newColumn = position.first + move[0];
            int newRow = position.second + move[1];

            if (isValidSquare(newColumn, newRow) && isNotOccupied(newColumn, newRow, white, black)) {
                if(Math.abs(yourKing.position.first - newColumn) <= 1 && Math.abs(yourKing.position.second - newRow) <= 1)
                    continue;
                possibleMoves.add(new Pair<>(newColumn, newRow));
            }
        }
        movesList = possibleMoves;
        return possibleMoves;
    }
}