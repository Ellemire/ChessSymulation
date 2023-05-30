package Chess;

import android.util.Pair;

import java.util.ArrayList;

public class Rook extends Piece {

    private boolean wasMoved;

    //gettery i settery
    public boolean isWasMoved() {
        return wasMoved;
    }
    public void setWasMoved(boolean wasMoved) {
        this.wasMoved = wasMoved;
    }

    //konstruktor
    public Rook(Pair<Integer, Integer> position, boolean color){
        super(position,color);

        if(!color)//biały
            PiecesListWhite.add(position);
        if(color)//czarny
            PiecesListBlack.add(position);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> calculatePossibleMoves() {
        ArrayList<Pair<Integer, Integer>> possibleMoves = new ArrayList<>();

        // Ruchy wzdłuż kolumn
        for (int row = 0; row < 8; row++) {
            Check();
            if (row != position.second && IsNotOccupied(position.first, row) && !isCheck) {
                possibleMoves.add(new Pair<>(position.first, row));
            }
        }

        // Ruchy wzdłuż wierszy
        for (int column = 0; column < 8; column++) {
            Check();
            if (column != position.first && IsNotOccupied(column, position.second) && !isCheck) {
                possibleMoves.add(new Pair<>(column, position.second));
            }
        }

        return possibleMoves;
    }
    private boolean IsNotOccupied (int column, int row) {
        Pair<Integer, Integer> pair = new Pair<>(column, row);
        if (!color && PiecesListWhite.contains(pair))
            return false;
        if (color && PiecesListBlack.contains(pair))
            return false;
        return true;
    }

    private boolean isCheck(ArrayList<Pair<Integer, Integer>> pieces, Pair<Integer, Integer> kingPosition) {
        for (Pair<Integer, Integer> piece : pieces) {
            if (isAttacking(piece, kingPosition)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAttacking(Pair<Integer, Integer> piece, Pair<Integer, Integer> kingPosition) {
        int pieceColumn = piece.first;
        int pieceRow = piece.second;
        int kingColumn = kingPosition.first;
        int kingRow = kingPosition.second;

        // Sprawdzamy, czy figura atakuje króla na wprost (pionowo, poziomo lub na skos)
        if (pieceColumn == kingColumn || pieceRow == kingRow || Math.abs(pieceColumn - kingColumn) == Math.abs(pieceRow - kingRow)) {
            return true;
        }

        // Sprawdzamy, czy figura atakuje króla jako skoczek
        int columnDiff = Math.abs(pieceColumn - kingColumn);
        int rowDiff = Math.abs(pieceRow - kingRow);
        if (columnDiff == 2 && rowDiff == 1 || columnDiff == 1 && rowDiff == 2) {
            return true;
        }

        // Sprawdzamy, czy figura atakuje króla jako pionek
        int direction = 1; // Kierunek ataku pionka (1 - w górę, -1 - w dół)
        if (pieceRow > kingRow) {
            direction = -1;
        }
        if (pieceColumn == kingColumn + 1 || pieceColumn == kingColumn - 1) {
            if (pieceRow == kingRow + direction) {
                return true;
            }
        }

        return false;
    }
    boolean isCheck;
    private void Check(){
        ArrayList<Pair<Integer, Integer>> pieces = new ArrayList<>();
        if(color)
            isCheck= isCheck(PiecesListBlack, kingPosition);
        if(!color)
            isCheck= isCheck(PiecesListWhite, kingPosition);
    }
}
