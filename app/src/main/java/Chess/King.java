package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class King extends Piece {

    private final int[][] MOVES = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    //konstruktor
    public King(Pair<Integer, Integer> position, boolean color) {
        super(position, color);
        this.position = position;
    }

    //sprawdza możliwe ruchy dla króla + dodać roszadę
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