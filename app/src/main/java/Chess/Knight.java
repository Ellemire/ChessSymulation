package Chess;

import android.util.Pair;

import java.util.ArrayList;
/**
 * Klasa "Skoczek" dziedzicząca po klasie "Bierka" (ang. Piece)
 */
public class Knight extends Piece {


    //konstruktor
    /** Konstruktor obiektu typu "Skoczek".
     * @param position pozycja bierki zapisana w formie pary obiektów typu Integer
     * @param color kolor bierki: true - biały, false - czarny
     */
    public Knight(Pair<Integer, Integer> position, boolean color)
    {
        super(position,color);
    }

    /**
     * Wektory ruchu dla skoczka.
     */
    private final int[][] MOVES = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    /** Metoda zwracająca możliwe ruchy do wykonania dla skoczka.
     * Skoczek porusza się zgodnie z wektorami podanymi w parametrze MOVES (kształt litery "L").
     * Może przeskakiwać przez pozostałe bierki.
     * @param white    lista białych bierek
     * @param black    lista czarnych bierek
     * @param yourKing pozycja króla w kolorze danej figury
     * @return lista dostępnych ruchów
     */
    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        for (int[] move : MOVES) {
            int newColumn = position.first + move[0];
            int newRow = position.second + move[1];
            if (isValidSquare(newColumn, newRow) && isNotOccupied(newColumn, newRow, white, black))
                possibleMoves.add(new Pair<>(newColumn, newRow));
        }
        movesList = possibleMoves;
        return possibleMoves;
    }
}