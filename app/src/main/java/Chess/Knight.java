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
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.addAll(white);
        pieces.addAll(black);

        for (int[] move : MOVES) {
            int newColumn = position.first + move[0];
            int newRow = position.second + move[1];
            if (isValidSquare(newColumn, newRow) && IsNotOccupied(newColumn, newRow, white, black) && !isCheck(pieces, yourKing))
                possibleMoves.add(new Pair<>(newColumn, newRow));
        }
        movesList = possibleMoves;
        return possibleMoves;
    }

    @Override
    protected boolean isAttacking(Piece piece, Pair<Integer, Integer> oppositeKingPosition) {
        // Sprawdzamy, czy figura atakuje króla jako skoczek
        int columnDiff = Math.abs(piece.getPosition().first - oppositeKingPosition.first);
        int rowDiff = Math.abs(piece.getPosition().second - oppositeKingPosition.second);
        if (columnDiff == 2 && rowDiff == 1 || columnDiff == 1 && rowDiff == 2)
            return true;
        return false;
    }
}