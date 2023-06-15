package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class Knight extends Piece {

    //konstruktor
    public Knight(Pair<Integer, Integer> position, boolean color)
    {
        super(position,color);
    }

    private final int[][] MOVES = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

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