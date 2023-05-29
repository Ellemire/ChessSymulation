package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class King extends Piece {

    public King(Pair<Integer, Integer> position, boolean color, ArrayList<Pair<Integer,Integer>> movesList){super(position,color,movesList);}
    private final int[][] MOVES = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public ArrayList<Pair<Integer, Integer>> calculatePossibleKingMoves(int currentColumn, int currentRow) {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        for (int[] move : MOVES) {
            int newColumn = currentColumn + move[0];
            int newRow = currentRow + move[1];

            if (isValidSquare(newColumn, newRow) && IsNotOccupied(newColumn, newRow)) {
                possibleMoves.add(new Pair<>(newColumn, newRow));
            }
        }

        return possibleMoves;
    }

    private boolean isValidSquare(int column, int row) {
        return column >= 0 && column < 8 && row >= 0 && row < 8;
    }

    private boolean IsNotOccupied (int column, int row) {
        Pair<Integer, Integer> pair = new Pair<>(column, row);
        if (!color && PiecesListWhite.contains(pair))
            return false;
        if (color && PiecesListBlack.contains(pair))
            return false;
        return true;
    }
    public void Generate_King(){
        int currentColumn = position.second;
        int currentRow = position.first;

        ArrayList<Pair<Integer, Integer>> possibleMoves = calculatePossibleKingMoves(currentColumn, currentRow);

        for(Pair<Integer, Integer> moves : possibleMoves) {
            movesList.add(moves);
        }
    }

    public boolean isWasMoved() {
        return wasMoved;
    }

    public void setWasMoved(boolean wasMoved) {
        this.wasMoved = wasMoved;
    }

    private boolean wasMoved;

}