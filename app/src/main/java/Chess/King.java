package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class King extends Piece {

    private boolean wasMoved;
    private final int[][] MOVES = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    //konstruktor
    public King(Pair<Integer, Integer> position, boolean color, boolean wasMoved) {
        super(position, color);
        this.wasMoved = wasMoved;
    }

    //gettery i settery
    public boolean isWasMoved() {
        return wasMoved;
    }
    public void setWasMoved(boolean wasMoved) {
        this.wasMoved = wasMoved;
    }

    //sprawdza możliwe ruchy dla króla + dodać roszadę
    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves(ArrayList<Piece> white, ArrayList<Piece> black, Piece yourKing) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.addAll(white);
        pieces.addAll(black);

        for (int[] move : MOVES) {
            int newColumn = position.first + move[0];
            int newRow = position.second + move[1];

            if (isValidSquare(newColumn, newRow) && IsNotOccupied(newColumn, newRow, white, black)) {
                possibleMoves.add(new Pair<>(newColumn, newRow));
            }
        }
        movesList = possibleMoves;
        return possibleMoves;
    }

}