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

        if(!color)//biały
            PiecesListWhite.add(position);
        if(color)//czarny
            PiecesListBlack.add(position);
    }

    //gettery i settery
    public boolean isWasMoved() {
        return wasMoved;
    }
    public void setWasMoved(boolean wasMoved) {
        this.wasMoved = wasMoved;
    }

    //sprawdza możliwe ruchy dla króla
    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves() {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        for (int[] move : MOVES) {
            int newColumn = position.first + move[0];
            int newRow = position.second + move[1];

            if (isValidSquare(newColumn, newRow) && IsNotOccupied(newColumn, newRow)) {
                possibleMoves.add(new Pair<>(newColumn, newRow));
            }
        }

        return possibleMoves;
    }

    //sprawdza czy istnieje dane pole
    private boolean isValidSquare(int column, int row) {
        return column >= 0 && column < 8 && row >= 0 && row < 8;
    }

    //sprawdza czy pole jest zajęte
    private boolean IsNotOccupied (int column, int row) {
        Pair<Integer, Integer> pair = new Pair<>(column, row);
        if (!color && PiecesListWhite.contains(pair))
            return false;
        if (color && PiecesListBlack.contains(pair))
            return false;
        return true;
    }
}